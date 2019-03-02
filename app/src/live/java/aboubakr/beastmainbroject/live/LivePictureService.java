package aboubakr.beastmainbroject.live;

import android.support.annotation.NonNull;

import com.aboubakr.beastmainbroject.entities.EventPicture;
import com.aboubakr.beastmainbroject.entities.firebaseEntities.EventPictureFirebase;
import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.aboubakr.beastmainbroject.services.EventPhotoServices;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;


public class LivePictureService extends BaseLiveService {
    public LivePictureService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void getCommunityPictures(EventPhotoServices.SearchCommunityPhotoRequest request) {
        final EventPhotoServices.SearchCommunityPhotoResponse response = new EventPhotoServices.SearchCommunityPhotoResponse();
        response.communityPhotos = new ArrayList<>();
        DatabaseReference databaseReference = FirebaseDatabase
                .getInstance()
                .getReferenceFromUrl(request.fireBaseUrl);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    EventPictureFirebase eventCardFirebase = ds.getValue(EventPictureFirebase.class);
                    EventPicture eventPicture = new EventPicture(
                            eventCardFirebase.getUrl()
                    );
                    response.communityPhotos.add(eventPicture);
                }
                bus.post(response);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


//        response.communityPhotos.add(new EventPicture("http://lorempixel.com/400/400/people/1"));
//        response.communityPhotos.add(new EventPicture("http://lorempixel.com/400/400/people/2"));
//        response.communityPhotos.add(new EventPicture("http://lorempixel.com/400/400/people/3"));
//
//        int index = 0;
//        DatabaseReference firbaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
//        for(EventPicture eventPicture: response.communityPhotos){
//            DatabaseReference picReference = firbaseDatabaseReference
//                    .child("data")
//                    .child("eventPics")
//                    .child("community")
//                    .child(Integer.toString(index));
//            picReference.child("url").setValue(eventPicture.getPictureUrl());
//            index++;
//
//        }
//        bus.post(response);
    }

    @Subscribe
    public void getBrotherhoodPictures(EventPhotoServices.SearchBrotherHoodPhotoRequest request) {
        final EventPhotoServices.SearchBrotherHoodPhotoResponse response = new EventPhotoServices.SearchBrotherHoodPhotoResponse();
        response.brotherHoodPhotos = new ArrayList<>();
        DatabaseReference databaseReference = FirebaseDatabase
                .getInstance()
                .getReferenceFromUrl(request.fireBaseUrl);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    EventPictureFirebase eventCardFirebase = ds.getValue(EventPictureFirebase.class);
                    EventPicture eventPicture = new EventPicture(
                            eventCardFirebase.getUrl()
                    );

                    response.brotherHoodPhotos.add(eventPicture);
                }

                bus.post(response);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        response.brotherHoodPhotos.add(new EventPicture("http://lorempixel.com/400/400/sports/1"));
//        response.brotherHoodPhotos.add(new EventPicture("http://lorempixel.com/400/400/sports/2"));
//        response.brotherHoodPhotos.add(new EventPicture("http://lorempixel.com/400/400/sports/3"));
//
//        int index = 0;
//        DatabaseReference firbaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
//        for(EventPicture eventPicture: response.brotherHoodPhotos){
//            DatabaseReference picReference = firbaseDatabaseReference
//                    .child("data")
//                    .child("eventPics")
//                    .child("brotherHood")
//                    .child(Integer.toString(index));
//            picReference.child("url").setValue(eventPicture.getPictureUrl());
//            index++;
//
//        }

//        bus.post(response);
    }

    @Subscribe
    public void getSocialPictures(EventPhotoServices.SearchSocialPhotoRequest request) {
        final EventPhotoServices.SearchSocialPhotoResponse response = new EventPhotoServices.SearchSocialPhotoResponse();
        response.socialPhotos = new ArrayList<>();
        DatabaseReference databaseReference = FirebaseDatabase
                .getInstance()
                .getReferenceFromUrl(request.fireBaseUrl);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    EventPictureFirebase eventCardFirebase = ds.getValue(EventPictureFirebase.class);
                    EventPicture eventPicture = new EventPicture(
                            eventCardFirebase.getUrl()
                    );

                    response.socialPhotos.add(eventPicture);
                }

                bus.post(response);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        response.socialPhotos.add(new EventPicture("http://lorempixel.com/400/400/nature/1"));
//        response.socialPhotos.add(new EventPicture("http://lorempixel.com/400/400/nature/2"));
//        response.socialPhotos.add(new EventPicture("http://lorempixel.com/400/400/nature/3"));
//
//        int index = 0;
//        DatabaseReference firbaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
//        for(EventPicture eventPicture: response.socialPhotos){
//            DatabaseReference picReference = firbaseDatabaseReference
//                    .child("data")
//                    .child("eventPics")
//                    .child("socials")
//                    .child(Integer.toString(index));
//            picReference.child("url").setValue(eventPicture.getPictureUrl());
//            index++;
//
//        }
//        bus.post(response);
    }
}
