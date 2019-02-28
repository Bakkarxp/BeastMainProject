package com.aboubakr.beastmainbroject.entities.firebaseEntities;


public class FraternityEventFirebase {
    private String name, description, image, youtube;
    private boolean video;

    public FraternityEventFirebase() {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getYoutube() {
        return youtube;
    }

    public boolean isVideo() {
        return video;
    }
}
