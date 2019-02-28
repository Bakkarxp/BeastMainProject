package com.aboubakr.beastmainbroject.services;


import com.aboubakr.beastmainbroject.entities.EventPicture;

import java.util.List;


public class EventPhotoServices {
    private EventPhotoServices() {

    }

    public static class SearchCommunityPhotoRequest {
        public String fireBaseUrl;

        public SearchCommunityPhotoRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchCommunityPhotoResponse {
        public List<EventPicture> communityPhotos
                ;
    }

    public static class SearchBrotherHoodPhotoRequest {
        public String fireBaseUrl;

        public SearchBrotherHoodPhotoRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchBrotherHoodPhotoResponse {
        public List<EventPicture> brotherHoodPhotos;
    }

    public static class SearchSocialPhotoRequest {
        public String fireBaseUrl;

        public SearchSocialPhotoRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchSocialPhotoResponse {
        public List<EventPicture> socialPhotos;
    }
}
