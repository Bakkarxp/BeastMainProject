package com.aboubakr.beastmainbroject.infrastructure;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.otto.Bus;

import aboubakr.beastmainbroject.live.Module;


// Otto is an event bus designed to decouple different parts of your application
// while still allowing them to communicate efficiently.

public class BeastApplication extends Application {
    Bus bus;

    public static final String YOUTUBE_API_KEY = "AIzaSyBz12uwuba1wFNBW8zaDz9bgrTaLVwmiOc";

    public static final String FIREBASE_BROTHERS_REFERENCE = "https://beastmainproject-231722.firebaseio.com/data/brother";
    public static final String FIREBASE_EVENT_CARDS_COMMUNITY = "https://beastmainproject-231722.firebaseio.com/data/eventCards/community";
    public static final String FIREBASE_EVENT_CARDS_BROTHERHOOD = "https://beastmainproject-231722.firebaseio.com/data/eventCards/brotherhood";
    public static final String FIREBASE_EVENT_CARDS_SOCIAL = "https://beastmainproject-231722.firebaseio.com/data/eventCards/social";
    public static final String FIREBASE_EVENT_PICTURES_COMMUNITY = "https://beastmainproject-231722.firebaseio.com/data/eventPictures/community";
    public static final String FIREBASE_EVENT_PICTURES_BROTHERHOOD = "https://beastmainproject-231722.firebaseio.com/data/eventPictures/brotherhood";
    public static final String FIREBASE_EVENT_PICTURES_SOCIAL = "https://beastmainproject-231722.firebaseio.com/data/eventPictures/social";
    public static final String FIREBASE_RUSH_COMMUNITY = "https://beastmainproject-231722.firebaseio.com/data/rushEvents/community";
    public static final String FIREBASE_RUSH_SOCIAL = "https://beastmainproject-231722.firebaseio.com/data/rushEvents/social";




    // singleton
    public BeastApplication() {
        bus = new Bus();
    }

    public Bus getBus() {
        return bus;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if(!FirebaseApp.getApps(this).isEmpty()){
            // Enable disk persistence
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
        Module.Register(this);


    }
}
