package com.flutter.app.User.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Data
@Document
@AllArgsConstructor
public class User
{
    @Id
    private String id;

    @NotEmpty
    private String firstname;

    @NotEmpty
    private String lastname;

    @NotEmpty
    private String avatarUrl;

    @NotEmpty
    private String backdropPhotoUrl;

    @NotEmpty
    private String biography;

    @NotEmpty
    private String location; //long lat later

}
