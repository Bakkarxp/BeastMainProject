package aboubakr.beastmainbroject.live;


import android.support.annotation.NonNull;

import com.aboubakr.beastmainbroject.entities.EventCard;
import com.aboubakr.beastmainbroject.entities.firebaseEntities.EventCardFirebase;
import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.aboubakr.beastmainbroject.services.EventCardService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;



public class LiveCardsService extends BaseLiveService {
    public LiveCardsService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void searchCommunityCards(EventCardService.SearchCommunityServiceCardRequest request) {
       final EventCardService.SearchCommunityServiceCardResponse response = new EventCardService.SearchCommunityServiceCardResponse();
        response.communityServiceCards = new ArrayList<>();
        DatabaseReference databaseReference = FirebaseDatabase
                .getInstance()
                .getReferenceFromUrl(request.fireBaseUrl);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        int index = 1;
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            EventCardFirebase eventCardFirebase = ds.getValue(EventCardFirebase.class);
                            EventCard eventCard = new EventCard(
                                    index,
                                    eventCardFirebase.getTitle(),
                                    eventCardFirebase.getDescription(),
                                    eventCardFirebase.getPicture(),
                                    eventCardFirebase.isVideo(),
                                    eventCardFirebase.getUrl()
                            );

                            response.communityServiceCards.add(eventCard);
                            index++;
                        }

                        bus.post(response);
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
//        response.communityServiceCards.add(new EventCard(
//                1,
//                "Community event 1",
//                "Community event 1 description",
//                "http://lorempixel.com/400/400/people/1",
//                false,
//                null
//        ));
//
//        response.communityServiceCards.add(new EventCard(
//                2,
//                "Community event 2",
//                "Community event 2 description",
//                "http://lorempixel.com/400/400/people/2",
//                true,
//                "RuFgxNtWdvQ"
//        ));
//
//        int index = 0;
//        DatabaseReference firbaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
//        for(EventCard eventCard: response.communityServiceCards){
//            DatabaseReference cardReference = firbaseDatabaseReference
//                    .child("data")
//                    .child("eventCards")
//                    .child("community")
//                    .child(Integer.toString(index));
//            cardReference.child("name").setValue(eventCard.getEventName());
//            cardReference.child("description").setValue(eventCard.getEventDescription());
//            cardReference.child("picture").setValue(eventCard.getEventImage());
//            cardReference.child("video").setValue(eventCard.isVideo());
//            cardReference.child("url").setValue(eventCard.getYoutubeEnding());
//            index++;
//
//        }
//        bus.post(response);
    }

    @Subscribe
    public void searchBrotherHoodCards(EventCardService.SearchBrotherHoodCardRequest request) {
        final EventCardService.SearchBrotherhoodCardResponse response = new EventCardService.SearchBrotherhoodCardResponse();
        response.brotherHoodCards = new ArrayList<>();
        DatabaseReference databaseReference = FirebaseDatabase
                .getInstance()
                .getReferenceFromUrl(request.fireBaseUrl);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int index = 3;
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    EventCardFirebase eventCardFirebase = ds.getValue(EventCardFirebase.class);
                    EventCard eventCard = new EventCard(
                            index,
                            eventCardFirebase.getTitle(),
                            eventCardFirebase.getDescription(),
                            eventCardFirebase.getPicture(),
                            eventCardFirebase.isVideo(),
                            eventCardFirebase.getUrl()
                    );

                    response.brotherHoodCards.add(eventCard);
                    index++;
                }

                bus.post(response);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        response.brotherHoodCards.add(new EventCard(
//                3,
//                "Brotherhood event 1",
//                "Community event 1 description",
//                "http://lorempixel.com/400/400/business/1",
//                false,
//                null
//        ));
//
//        response.brotherHoodCards.add(new EventCard(
//                4,
//                "Brotherhood event 2",
//                "Brotherhood event 2 description",
//                "http://lorempixel.com/400/400/business/2",
//                true,
//                "RuFgxNtWdvQ"
//        ));
//
//        int index = 0;
//        DatabaseReference firbaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
//        for(EventCard eventCard: response.brotherHoodCards){
//            DatabaseReference cardReference = firbaseDatabaseReference
//                    .child("data")
//                    .child("eventCards")
//                    .child("brotherHood")
//                    .child(Integer.toString(index));
//            cardReference.child("name").setValue(eventCard.getEventName());
//            cardReference.child("description").setValue(eventCard.getEventDescription());
//            cardReference.child("picture").setValue(eventCard.getEventImage());
//            cardReference.child("video").setValue(eventCard.isVideo());
//            cardReference.child("url").setValue(eventCard.getYoutubeEnding());
//            index++;
//
//        }
//        bus.post(response);
    }

    @Subscribe
    public void searchSocialCards(EventCardService.SearchSocialCardRequest request) {
        final EventCardService.SearchSocialCardResponse response = new EventCardService.SearchSocialCardResponse();
        response.socialCards = new ArrayList<>();
        DatabaseReference databaseReference = FirebaseDatabase
                .getInstance()
                .getReferenceFromUrl(request.fireBaseUrl);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int index = 5;
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    EventCardFirebase eventCardFirebase = ds.getValue(EventCardFirebase.class);
                    EventCard eventCard = new EventCard(
                            index,
                            eventCardFirebase.getTitle(),
                            eventCardFirebase.getDescription(),
                            eventCardFirebase.getPicture(),
                            eventCardFirebase.isVideo(),
                            eventCardFirebase.getUrl()
                    );

                    response.socialCards.add(eventCard);
                    index++;
                }

                bus.post(response);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        response.socialCards.add(new EventCard(
//                5,
//                "Social event 1",
//                "Social event 1 description",
//                "http://lorempixel.com/400/400/nature/1",
//                false,
//                null
//        ));
//
//        response.socialCards.add(new EventCard(
//                6,
//                "Social event 2",
//                "Social event 2 description",
//                "http://lorempixel.com/400/400/nature/2",
//                true,
//                "RuFgxNtWdvQ"
//        ));
//        int index = 0;
//        DatabaseReference firbaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
//        for(EventCard eventCard: response.socialCards){
//            DatabaseReference cardReference = firbaseDatabaseReference
//                    .child("data")
//                    .child("eventCards")
//                    .child("socials")
//                    .child(Integer.toString(index));
//            cardReference.child("name").setValue(eventCard.getEventName());
//            cardReference.child("description").setValue(eventCard.getEventDescription());
//            cardReference.child("picture").setValue(eventCard.getEventImage());
//            cardReference.child("video").setValue(eventCard.isVideo());
//            cardReference.child("url").setValue(eventCard.getYoutubeEnding());
//            index++;
//
//        }

//        bus.post(response);
    }
}
