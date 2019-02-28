package aboubakr.beastmainbroject.inmemory;


import com.aboubakr.beastmainbroject.entities.EventCard;
import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.aboubakr.beastmainbroject.services.EventCardService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;



public class InMemoryCardsService extends BaseInMemory {
    public InMemoryCardsService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void searchCommunityCards(EventCardService.SearchCommunityServiceCardRequest request) {
        EventCardService.SearchCommunityServiceCardResponse response = new EventCardService.SearchCommunityServiceCardResponse();
        response.communityServiceCards = new ArrayList<>();

        response.communityServiceCards.add(new EventCard(
                1,
                "Community event 1",
                "Community event 1 description",
                "http://lorempixel.com/400/400/people/1",
                false,
                null
        ));

        response.communityServiceCards.add(new EventCard(
                2,
                "Community event 2",
                "Community event 2 description",
                "http://lorempixel.com/400/400/people/2",
                true,
                "RuFgxNtWdvQ"
        ));

        bus.post(response);
    }

    @Subscribe
    public void searchBrotherHoodCards(EventCardService.SearchBrotherHoodCardRequest request) {
        EventCardService.SearchBrotherhoodCardResponse response = new EventCardService.SearchBrotherhoodCardResponse();
        response.brotherHoodCards = new ArrayList<>();

        response.brotherHoodCards.add(new EventCard(
                3,
                "Brotherhood event 1",
                "Community event 1 description",
                "http://lorempixel.com/400/400/business/1",
                false,
                null
        ));

        response.brotherHoodCards.add(new EventCard(
                4,
                "Brotherhood event 2",
                "Brotherhood event 2 description",
                "http://lorempixel.com/400/400/business/2",
                true,
                "RuFgxNtWdvQ"
        ));

        bus.post(response);
    }

    @Subscribe
    public void searchSocialCards(EventCardService.SearchSocialCardRequest request) {
        EventCardService.SearchSocialCardResponse response = new EventCardService.SearchSocialCardResponse();
        response.socialCards = new ArrayList<>();

        response.socialCards.add(new EventCard(
                5,
                "Social event 1",
                "Social event 1 description",
                "http://lorempixel.com/400/400/nature/1",
                false,
                null
        ));

        response.socialCards.add(new EventCard(
                6,
                "Social event 2",
                "Social event 2 description",
                "http://lorempixel.com/400/400/nature/2",
                true,
                "RuFgxNtWdvQ"
        ));

        bus.post(response);
    }
}
