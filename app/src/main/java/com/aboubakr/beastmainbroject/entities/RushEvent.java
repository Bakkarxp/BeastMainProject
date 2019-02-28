package com.aboubakr.beastmainbroject.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class RushEvent implements Parcelable {
    private int eventId;
    private String eventName;
    private String eventDate;
    private String eventTime;
    private String eventLocation;
    private double eventLatitude;
    private double eventLongitude;
    private boolean isOnCampus;
    private String eventDescription;

    public RushEvent(int eventId,
                     String eventName,
                     String eventDate,
                     String eventTime,
                     String eventLocation,
                     double eventLatitude,
                     double eventLongitude,
                     boolean isOnCampus,
                     String eventDescription) {

        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventLocation = eventLocation;
        this.eventLatitude = eventLatitude;
        this.eventLongitude = eventLongitude;
        this.isOnCampus = isOnCampus;
        this.eventDescription = eventDescription;
    }

    protected RushEvent(Parcel in) {
        this.eventId = in.readInt();
        this.eventName = in.readString();
        this.eventDate = in.readString();
        this.eventTime = in.readString();
        this.eventLocation = in.readString();
        this.eventLatitude = in.readDouble();
        this.eventLongitude = in.readDouble();
        this.isOnCampus = in.readByte() != 0;
        this.eventDescription = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(eventId);
        dest.writeString(eventName);
        dest.writeString(eventDate);
        dest.writeString(eventTime);
        dest.writeString(eventLocation);
        dest.writeDouble(eventLatitude);
        dest.writeDouble(eventLongitude);
        dest.writeByte((byte) (isOnCampus ?1 : 0));
        dest.writeString(eventDescription);
    }

    public static final Creator<RushEvent> CREATOR = new Creator<RushEvent>() {
        @Override
        public RushEvent createFromParcel(Parcel in) {
            return new RushEvent(in);
        }

        @Override
        public RushEvent[] newArray(int size) {
            return new RushEvent[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public double getEventLatitude() {
        return eventLatitude;
    }

    public double getEventLongitude() {
        return eventLongitude;
    }

    public boolean isOnCampus() {
        return isOnCampus;
    }

    public String getEventDescription() {
        return eventDescription;
    }
}
