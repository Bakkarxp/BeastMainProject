package aboubakr.beastmainbroject.live;


import android.support.annotation.NonNull;

import com.aboubakr.beastmainbroject.entities.RushEvent;
import com.aboubakr.beastmainbroject.entities.firebaseEntities.RushFirebase;
import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.aboubakr.beastmainbroject.services.RushEventServices;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;


public class LiveRushEventService extends BaseLiveService {
    public LiveRushEventService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void searchCommunityServiceRushEvents(RushEventServices.RushCommunityServiceServicesSearchRequest request) {
        final RushEventServices.RushCommunityServiceServicesSearchResponse response = new RushEventServices.RushCommunityServiceServicesSearchResponse();
        response.communityServiceRushEvents = new ArrayList<>();
        DatabaseReference databaseReference = FirebaseDatabase
                .getInstance()
                .getReferenceFromUrl(request.fireBaseUrl);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int index = 0;
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    RushFirebase rushFirebase = ds.getValue(RushFirebase.class);
                    RushEvent rushEvent = new RushEvent(
                            index,
                            rushFirebase.getName(),
                            rushFirebase.getDate(),
                            rushFirebase.getTime(),
                            rushFirebase.getLocation(),
                            rushFirebase.getLatitude(),
                            rushFirebase.getLongitude(),
                            rushFirebase.isCampus(),
                            rushFirebase.getDescription()
                    );
                    response.communityServiceRushEvents.add(rushEvent);
                    index++;
                }
                bus.post(response);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        response.communityServiceRushEvents.add(new RushEvent(
//                1,
//                "Rush Community event 1",
//                "09/05/2016",
//                "8:00pm",
//                "MR 202",
//                2.2,
//                2.2,
//                true,
//                "Rush Community event 1 description"
//        ));
//        response.communityServiceRushEvents.add(new RushEvent(
//                4,
//                "Rush Community event 2",
//                "09/05/2018",
//                "7:00pm",
//                "MR 202",
//                2.2,
//                2.2,
//                true,
//                "Rush Community event 2 description"
//        ));
//
//        int index = 0;
//        DatabaseReference firbaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
//        for(RushEvent rushEvent: response.communityServiceRushEvents){
//            DatabaseReference RushEventReference = firbaseDatabaseReference
//                    .child("data")
//                    .child("rushEvents")
//                    .child("community")
//                    .child(Integer.toString(index));
//            RushEventReference.child("name").setValue(rushEvent.getEventName());
//            RushEventReference.child("date").setValue(rushEvent.getEventDate());
//            RushEventReference.child("time").setValue(rushEvent.getEventTime());
//            RushEventReference.child("location").setValue(rushEvent.getEventLocation());
//            RushEventReference.child("latitude").setValue(rushEvent.getEventLatitude());
//            RushEventReference.child("longitude").setValue(rushEvent.getEventLongitude());
//            RushEventReference.child("campus").setValue(rushEvent.isOnCampus());
//            RushEventReference.child("description").setValue(rushEvent.getEventDescription());
//            index++;
//        }
//        bus.post(response);
    }

    @Subscribe
    public void searchSocialRushEvents(RushEventServices.RushSocialServicesSearchRequest request) {
        final RushEventServices.RushSocialServicesSearchResponse response = new RushEventServices.RushSocialServicesSearchResponse();
        response.socialRushEvents = new ArrayList<>();
        DatabaseReference databaseReference = FirebaseDatabase
                .getInstance()
                .getReferenceFromUrl(request.fireBaseUrl);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int index = 0;
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    RushFirebase rushFirebase = ds.getValue(RushFirebase.class);
                    RushEvent rushEvent = new RushEvent(
                            index,
                            rushFirebase.getName(),
                            rushFirebase.getDate(),
                            rushFirebase.getTime(),
                            rushFirebase.getLocation(),
                            rushFirebase.getLatitude(),
                            rushFirebase.getLongitude(),
                            rushFirebase.isCampus(),
                            rushFirebase.getDescription()
                    );
                    response.socialRushEvents.add(rushEvent);
                    index++;
                }
                bus.post(response);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        response.socialRushEvents.add(new RushEvent(
//                2,
//                "Rush Social event 1",
//                "09/05/2016",
//                "8:00pm",
//                "100 Collins Street, Melbourne, VIC, 3000",
//                -37.814228,
//                144.970040,
//                false,
//                "Rush Social event 1 description"
//        ));
//        response.socialRushEvents.add(new RushEvent(
//                3,
//                "Rush Social event 2",
//                "09/05/2018",
//                "11:00pm",
//                "100 Collins Street, Melbourne, VIC, 3000",
//                -37.814228,
//                144.970040,
//                false,
//                "Rush Social event 2 description"
//        ));
//
//        int index = 0;
//        DatabaseReference firbaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
//        for(RushEvent rushEvent: response.socialRushEvents){
//            DatabaseReference RushEventReference = firbaseDatabaseReference
//                    .child("data")
//                    .child("rushEvents")
//                    .child("socials")
//                    .child(Integer.toString(index));
//            RushEventReference.child("name").setValue(rushEvent.getEventName());
//            RushEventReference.child("date").setValue(rushEvent.getEventDate());
//            RushEventReference.child("time").setValue(rushEvent.getEventTime());
//            RushEventReference.child("location").setValue(rushEvent.getEventLocation());
//            RushEventReference.child("latitude").setValue(rushEvent.getEventLatitude());
//            RushEventReference.child("longitude").setValue(rushEvent.getEventLongitude());
//            RushEventReference.child("campus").setValue(rushEvent.isOnCampus());
//            RushEventReference.child("description").setValue(rushEvent.getEventDescription());
//            index++;
//        }
//        bus.post(response);
    }
}
