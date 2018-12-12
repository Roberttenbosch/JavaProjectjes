package com.flutter.app.Image.model;

public enum ImageType
{
    AVATAR("avatar"), BACKGROND("background"), NORMAL("normal");

    private final String imageTypeString;
    ImageType(String imageTypeString){
        this.imageTypeString = imageTypeString;
    }
    public String getImageTypeString(){
        return imageTypeString;
    }

}
