package com.aboubakr.beastmainbroject.services;



import com.aboubakr.beastmainbroject.entities.EventCard;

import java.util.List;


public class EventCardService {
    public EventCardService() {

    }

    public static class SearchCommunityServiceCardRequest {
        public String fireBaseUrl;

        public SearchCommunityServiceCardRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchCommunityServiceCardResponse {
        public List<EventCard> communityServiceCards;
    }

    public static class SearchBrotherHoodCardRequest {
        public String fireBaseUrl;

        public SearchBrotherHoodCardRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchBrotherhoodCardResponse {
        public List<EventCard> brotherHoodCards;
    }

    public static class SearchSocialCardRequest {
        public String fireBaseUrl;

        public SearchSocialCardRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchSocialCardResponse {
        public List<EventCard> socialCards;
    }
}
