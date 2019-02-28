package aboubakr.beastmainbroject.inmemory;


import com.aboubakr.beastmainbroject.entities.RushEvent;
import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.aboubakr.beastmainbroject.services.RushEventServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;


public class InMemoryRushEventService extends BaseInMemory {
    public InMemoryRushEventService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void searchCommunityServiceRushEvents(RushEventServices.RushCommunityServiceServicesSearchRequest request) {
        RushEventServices.RushCommunityServiceServicesSearchResponse response = new RushEventServices.RushCommunityServiceServicesSearchResponse();
        response.communityServiceRushEvents = new ArrayList<>();

        response.communityServiceRushEvents.add(new RushEvent(
                1,
                "Rush Community event 1",
                "09/05/2016",
                "8:00pm",
                "MR 202",
                2.2,
                2.2,
                true,
                "Rush Community event 1 description"
        ));
        response.communityServiceRushEvents.add(new RushEvent(
                4,
                "Rush Community event 2",
                "09/05/2018",
                "7:00pm",
                "MR 202",
                2.2,
                2.2,
                true,
                "Rush Community event 2 description"
        ));

        bus.post(response);
    }

    @Subscribe
    public void searchSocialRushEvents(RushEventServices.RushSocialServicesSearchRequest request) {
        RushEventServices.RushSocialServicesSearchResponse response = new RushEventServices.RushSocialServicesSearchResponse();
        response.socialRushEvents = new ArrayList<>();

        response.socialRushEvents.add(new RushEvent(
                2,
                "Rush Social event 1",
                "09/05/2016",
                "8:00pm",
                "100 Collins Street, Melbourne, VIC, 3000",
                -37.814228,
                144.970040,
                false,
                "Rush Social event 1 description"
        ));
        response.socialRushEvents.add(new RushEvent(
                3,
                "Rush Social event 2",
                "09/05/2018",
                "11:00pm",
                "100 Collins Street, Melbourne, VIC, 3000",
                -37.814228,
                144.970040,
                false,
                "Rush Social event 2 description"
        ));

        bus.post(response);
    }
}
