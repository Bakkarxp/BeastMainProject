package com.aboubakr.beastmainbroject.services;

import com.aboubakr.beastmainbroject.entities.Brother;

import java.util.List;

// this class represent the event args, the data passed with the event
//
public class BrotherServices {
    public BrotherServices () {
    }

    // this class carries the request url (firebase url)
    public static class BrotherSearchRequest {
        public String fireBaseUrl;

        public BrotherSearchRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }
    // this class carries the response after creating the request ( a list of brothers)
    public static class BrotherSearchResponse {
        public List<Brother> brothers;
    }
}
