package com.aboubakr.beastmainbroject.entities;

import android.os.Parcel;
import android.os.Parcelable;

// Parcelable allows object to be serialized so it can be passed between components
public class Brother implements Parcelable {
    private int brotherId;
    private String brotherName;
    private String brotherWhyJoin;
    private String brotherPicture;
    private String brotherMajor;
    private String brotherCrossSemister;
    private String brotherFunFact;

    public Brother(int brotherId, String brotherName, String brotherWhyJoin, String brotherPicture, String brotherMajor, String brotherCrossSemister, String brotherFunFact) {
        this.brotherId = brotherId;
        this.brotherName = brotherName;
        this.brotherWhyJoin = brotherWhyJoin;
        this.brotherPicture = brotherPicture;
        this.brotherMajor = brotherMajor;
        this.brotherCrossSemister = brotherCrossSemister;
        this.brotherFunFact = brotherFunFact;
    }

    protected Brother(Parcel in) {
        this.brotherId = in.readInt();
        this.brotherName = in.readString();
        this.brotherWhyJoin = in.readString();
        this.brotherPicture = in.readString();
        this.brotherMajor = in.readString();
        this.brotherCrossSemister = in.readString();
        this.brotherFunFact = in.readString();
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(brotherId);
        parcel.writeString(brotherName);
        parcel.writeString(brotherWhyJoin);
        parcel.writeString(brotherPicture);
        parcel.writeString(brotherMajor);
        parcel.writeString(brotherCrossSemister);
        parcel.writeString(brotherFunFact);
    }

    // Getters


    public int getBrotherId() {
        return brotherId;
    }

    public String getBrotherName() {
        return brotherName;
    }

    public String getBrotherWhyJoin() {
        return brotherWhyJoin;
    }

    public String getBrotherPicture() {
        return brotherPicture;
    }

    public String getBrotherMajor() {
        return brotherMajor;
    }

    public String getBrotherCrossSemister() {
        return brotherCrossSemister;
    }

    public String getBrotherFunFact() {
        return brotherFunFact;
    }




    public static final Creator<Brother> CREATOR = new Creator<Brother>() {
        @Override
        public Brother createFromParcel(Parcel in) {
            return new Brother(in);
        }

        @Override
        public Brother[] newArray(int size) {
            return new Brother[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


}
