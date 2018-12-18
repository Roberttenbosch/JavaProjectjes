package com.simple.appbackend.repository;


import com.simple.appbackend.model.Image;
import com.simple.appbackend.model.ImageType;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, String>
{
    Image findByUserIdAndImageType(String userId, ImageType type);
}
