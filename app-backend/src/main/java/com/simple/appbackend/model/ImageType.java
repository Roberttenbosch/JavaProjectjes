package com.simple.appbackend.model;

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
