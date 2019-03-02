package aboubakr.beastmainbroject.live;

import android.support.annotation.NonNull;

import com.aboubakr.beastmainbroject.entities.Brother;
import com.aboubakr.beastmainbroject.entities.firebaseEntities.BrotherFirebase;
import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.aboubakr.beastmainbroject.services.BrotherServices;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;


public class LiveBrotherService extends BaseLiveService {



    public LiveBrotherService(BeastApplication application) {
        super(application);
    }

    // subscribe to the event with BrotherSearchRequest
    // when event with BrotherSearchRequest is posted this will handle it
    @Subscribe
    public void getBrothers(BrotherServices.BrotherSearchRequest request) {
        final BrotherServices.BrotherSearchResponse response = new BrotherServices.BrotherSearchResponse();
        response.brothers = new ArrayList<>();
        DatabaseReference databaseReference = FirebaseDatabase
                .getInstance()
                .getReferenceFromUrl(request.fireBaseUrl);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int index = 0;
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    BrotherFirebase brotherFirebase = ds.getValue(BrotherFirebase.class);
                    Brother brother = new Brother(
                            index,
                            brotherFirebase.getName(),
                            brotherFirebase.getWhy(),
                            brotherFirebase.getPicture(),
                            brotherFirebase.getMajor(),
                            brotherFirebase.getCross(),
                            brotherFirebase.getFact()
                    );

                    response.brothers.add(brother);
                    index++;
                }

                bus.post(response);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
