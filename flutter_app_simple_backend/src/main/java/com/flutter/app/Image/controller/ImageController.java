package com.flutter.app.Image.controller;

import com.flutter.app.Image.model.ImageType;
import com.flutter.app.Image.service.ImageService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Controller
@RequestMapping("/image")
public class ImageController
{
    private final ImageService imageService;

    public ImageController(ImageService imageService)
    {
        this.imageService = imageService;
    }


    @GetMapping(value ="/{id}/raw",
            produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public Mono<ResponseEntity<?>> oneRawImage(
            @PathVariable String id)
    {
        return imageService.findImageOnDisk(id)
                .map(resource -> {
                    try {
                        return ResponseEntity.ok()
                                .contentLength(resource.contentLength())
                                .body(new InputStreamResource(
                                        resource.getInputStream()));
                    } catch (IOException e) {
                        return ResponseEntity.badRequest()
                                .body("Couldn't find image with" + id +
                                        " => " + e.getMessage());
                    }
                });
    }

    @GetMapping()
    public Mono<String> index(Model model)
    {
        model.addAttribute("images",
                imageService
                        .findAllImages());

        return Mono.just("index");
    }

    @PostMapping()
    public Mono<String> createFile(@RequestPart(name = "file")
                                           Flux<FilePart> files)
    {
        return imageService.saveImage(files, ImageType.NORMAL)
                .then(Mono.just("redirect:/image/"));
    }

    @DeleteMapping("/{id}")
    public Mono<String> deleteFile(@PathVariable String id)
    {
        return imageService.deleteImage(id)
                .then(Mono.just("redirect:/image/"));
    }


    @GetMapping(value = "/{userId}/avatar",  produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public Mono<ResponseEntity<?>> getAvatarImage(
            @PathVariable String userId)
    {
        return imageService.findAvatarImageOnDisk(userId)
                .map(resource -> {
                    try {
                        return ResponseEntity.ok()
                                .contentLength(resource.contentLength())
                                .body(new InputStreamResource(
                                        resource.getInputStream()));
                    } catch (IOException e) {
                        return ResponseEntity.badRequest()
                                .body("Couldn't find avatar image for user " + userId +
                                        " => " + e.getMessage());
                    }
                });
    }
    @GetMapping(value = "/{userId}/background",  produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public Mono<ResponseEntity<?>> getBackgroundImage(
            @PathVariable String userId)
    {
        return imageService.findBackgroundImageOnDisk(userId)
                .map(resource -> {
                    try {
                        return ResponseEntity.ok()
                                .contentLength(resource.contentLength())
                                .body(new InputStreamResource(
                                        resource.getInputStream()));
                    } catch (IOException e) {
                        return ResponseEntity.badRequest()
                                .body("Couldn't find background image for user " + userId +
                                        " => " + e.getMessage());
                    }
                });
    }
}
