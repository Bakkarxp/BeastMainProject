package aboubakr.beastmainbroject.live;

import com.aboubakr.beastmainbroject.entities.Brother;
import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.aboubakr.beastmainbroject.services.BrotherServices;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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
        BrotherServices.BrotherSearchResponse response = new BrotherServices.BrotherSearchResponse();
        response.brothers = new ArrayList<>();

        for (int i = 0; i < 48; i++) {
            String name = "brother" + i;
            String whyJoined = i + " joined for this reason";
            String url = "http://www.gravatar.com/avatar/"+i+"?d=monsterid&s=500";
            String major = "Computer Science " + i;
            String crossSemester = "Spring 2013";
            String funFact = "I love to code";
            response.brothers.add(new Brother(i, name, whyJoined, url, major, crossSemester, funFact));
        }
        int index = 0;
//
        // data are put inside bus
        // posting event with BrotherSearchResponse which carries the response
        bus.post(response);
    }
}
