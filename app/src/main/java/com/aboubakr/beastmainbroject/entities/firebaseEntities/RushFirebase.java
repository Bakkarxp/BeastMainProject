package com.aboubakr.beastmainbroject.entities.firebaseEntities;

public class RushFirebase {
    private String name, date, time, location;
    private double latitude, longitude;
    private boolean campus;
    private String description;

    public RushFirebase() {

    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean isCampus() {
        return campus;
    }

    public String getDescription() {
        return description;
    }
}
