package com.flutter.app.Image.repository;

import com.flutter.app.Image.model.Image;
import com.flutter.app.Image.model.ImageType;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ImageRepository extends ReactiveCrudRepository<Image, String>
{
    Mono<Image> findByUserIdAndImageType(String userId, ImageType type);
}
