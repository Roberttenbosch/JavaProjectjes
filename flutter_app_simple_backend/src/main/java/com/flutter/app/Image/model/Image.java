package com.flutter.app.Image.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
public class Image
{
    @Id
    private String id;
    private String title;
    private String url;
    private String userId;
    private ImageType imageType;
}
