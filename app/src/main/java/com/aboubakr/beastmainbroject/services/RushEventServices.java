package com.aboubakr.beastmainbroject.services;


import com.aboubakr.beastmainbroject.entities.RushEvent;

import java.util.List;

public class RushEventServices {
    public static class RushCommunityServiceServicesSearchRequest {
        public String fireBaseUrl;

        public RushCommunityServiceServicesSearchRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class RushCommunityServiceServicesSearchResponse {
        public List<RushEvent> communityServiceRushEvents;

    }

    public static class RushSocialServicesSearchRequest {
        public String fireBaseUrl;

        public RushSocialServicesSearchRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class RushSocialServicesSearchResponse {
        public List<RushEvent> socialRushEvents;

    }
}
