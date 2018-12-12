package com.flutter.app.Image.service;

import com.flutter.app.Image.model.Image;
import com.flutter.app.Image.model.ImageType;
import com.flutter.app.Image.repository.ImageRepository;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageService
{
    private static String UPLOAD_ROOT = "image-upload-dir";
    private final ResourceLoader resourceLoader;
    private final ImageRepository imageRepository;
    private final MeterRegistry meterRegistry;

    public ImageService(ResourceLoader resourceLoader, ImageRepository imageRepository, MeterRegistry meterRegistry)
    {
        init();
        this.resourceLoader = resourceLoader;
        this.imageRepository = imageRepository;
        this.meterRegistry = meterRegistry;
    }

    private void init()
    {
        Path path = Paths.get(UPLOAD_ROOT);
        if(Files.notExists(path))
        {
            try{
                Files.createDirectory(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Flux<Image> findAllImages()
    {
        return imageRepository.findAll()
                .log("findall");
    }

    public Mono<Resource> findAvatarImageOnDisk(String userId){
        Mono<Image> imageMono = imageRepository.findByUserIdAndImageType(userId, ImageType.AVATAR);
        return imageMono.flatMap(image -> findImageOnDisk(image.getId()));
    }

    public Mono<Resource> findBackgroundImageOnDisk(String userId){
        Mono<Image> imageMono = imageRepository.findByUserIdAndImageType(userId, ImageType.BACKGROND);
        return imageMono.flatMap(image -> findImageOnDisk(image.getId()));
    }

    public Mono<Resource> findImageOnDisk(String id)
    {
        return Mono.fromSupplier(() ->
                resourceLoader.getResource(
                        "file:" + UPLOAD_ROOT + "/" + id));
    }

    public Mono<Void> saveImage(Flux<FilePart> files, ImageType imageType)
    {
        return files
                .log("saveImage-files")
                .flatMap(file -> {
                    String id =  UUID.randomUUID().toString();
                    Mono<Image> saveDatabaseImage = imageRepository.save(
                            new Image(
                                    id,
                                    file.filename(),
                                    "url",
                                    "1",
                                    imageType))
                            .log("saveImage-save");
                    Mono<Void> copyFile = Mono.just(Paths.get(UPLOAD_ROOT, id).toFile())
                            .log("saveImage-picktarget")
                            .map(destFile -> {
                                try {
                                    destFile.createNewFile();
                                    return destFile;
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            })
                            .log("saveImage-newfile")
                            .flatMap(file::transferTo)
                            .log("saveImage-copy")
                            .then(Mono.fromRunnable(() ->
                                    meterRegistry
                                            .summary("files.uploaded.bytes")
                                            .record(Paths.get(UPLOAD_ROOT, file.filename()).toFile().length())
                            ));

                    return Mono.when(saveDatabaseImage, copyFile)
                            .log("saveImage-when");
                })
                .log("saveImage-flatMap")
                .then()
                .log("saveImage-done");
    }

    public Mono<Void> deleteImage(String id)
    {
        Mono<Void> deleteDatabaseImage = imageRepository
                .findById(id)
                .log("deleteImage-find")
                .flatMap(imageRepository::delete)
                .log("deleteImage-record");
        Mono<Object> deleteFile = Mono.fromRunnable(() -> {
            try {
                Files.deleteIfExists(
                        Paths.get(UPLOAD_ROOT, id));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        })
                .log("deleteImage-file");
        return Mono.when(deleteDatabaseImage, deleteFile)
                .log("deleteImage-when")
                .then()
                .log("deleteImage-done");
    }
}
