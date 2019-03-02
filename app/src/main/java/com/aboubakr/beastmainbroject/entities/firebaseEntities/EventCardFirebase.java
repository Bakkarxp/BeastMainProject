package com.aboubakr.beastmainbroject.entities.firebaseEntities;


public class EventCardFirebase {
    private String title;
    private String description;
    private String picture;
    private boolean video;
    private String url;

    public EventCardFirebase() {

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public String getUrl() {
        return url;
    }

    public boolean isVideo() {
        return video;
    }
}
