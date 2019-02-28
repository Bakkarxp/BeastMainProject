package com.aboubakr.beastmainbroject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aboubakr.beastmainbroject.R;
import com.aboubakr.beastmainbroject.activities.BaseActivity;
import com.aboubakr.beastmainbroject.activities.PhotoPagerActivity;
import com.aboubakr.beastmainbroject.activities.YoutubeActivity;
import com.aboubakr.beastmainbroject.entities.EventCard;
import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.aboubakr.beastmainbroject.services.EventCardService;
import com.aboubakr.beastmainbroject.views.AboutUsViews.AboutUsAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class AboutUsFragment extends BaseFragment implements AboutUsAdapter.AboutUsListener {

    private ArrayList<EventCard> serviceCards;
    private ArrayList<EventCard> brotherHoodCards;
    private ArrayList<EventCard> socialCards;

    private RecyclerView recyclerView;
    private AboutUsAdapter adapter;

    public static AboutUsFragment newInstance(){
        return  new AboutUsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about_us,container,false);

        adapter = new AboutUsAdapter((BaseActivity) getActivity(), this);
        serviceCards = adapter.getCommunityServiceEvents();
        brotherHoodCards = adapter.getBrotherHoodEvents();
        socialCards = adapter.getSocialEvents();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_about_us_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setUpAdapter();

        bus.post(new EventCardService.SearchCommunityServiceCardRequest("Hello"));
        bus.post(new EventCardService.SearchBrotherHoodCardRequest("Hello"));
        bus.post(new EventCardService.SearchSocialCardRequest("Hello"));

//        bus.post(new EventCardService.SearchCommunityServiceCardRequest(BeastApplication.FIREBASE_EVENT_CARDS_COMMUNITY));
//        bus.post(new EventCardService.SearchBrotherHoodCardRequest(BeastApplication.FIREBASE_EVENT_CARDS_BROTHERHOOD));
//        bus.post(new EventCardService.SearchSocialCardRequest(BeastApplication.FIREBASE_EVENT_CARDS_SOCIAL));




        return  rootView;
    }

    private void setUpAdapter() {
        if (isAdded()) {
            recyclerView.setAdapter(adapter);
        }
    }

    @Subscribe
    public void getCommunityEvents(EventCardService.SearchCommunityServiceCardResponse response) {
        int oldSize = serviceCards.size();
        if (oldSize == 0) {
            serviceCards.clear();
            adapter.notifyItemRangeRemoved(0, oldSize);
            serviceCards.addAll(response.communityServiceCards);
            adapter.notifyItemRangeChanged(0, serviceCards.size());
        }
    }

    @Subscribe
    public void getBrotherhoodEvents(EventCardService.SearchBrotherhoodCardResponse response) {
        int oldSize = brotherHoodCards.size();
        if (oldSize == 0) {
            brotherHoodCards.clear();
            adapter.notifyItemRangeRemoved(0, oldSize);
            brotherHoodCards.addAll(response.brotherHoodCards);
            adapter.notifyItemRangeChanged(0, brotherHoodCards.size());
        }
    }

    @Subscribe
    public void getSocialEvents(EventCardService.SearchSocialCardResponse response) {
        int oldSize = socialCards.size();
        if (oldSize == 0) {
            socialCards.clear();
            adapter.notifyItemRangeRemoved(0, oldSize);
            socialCards.addAll(response.socialCards);
            adapter.notifyItemRangeChanged(0, socialCards.size());
        }
    }

    @Override
    public void OnEventCardClick(EventCard eventCard) {
        if (eventCard.isVideo()) {
            Log.i(AboutUsFragment.class.getSimpleName(), eventCard.getEventName() + " is a video " + eventCard.getYoutubeEnding());
            Intent intent = YoutubeActivity.newIntent(getActivity(), eventCard);
            startActivity(intent);
        } else {
            Log.i(AboutUsFragment.class.getSimpleName(), eventCard.getEventName() + " is a picture");
            Intent intent = PhotoPagerActivity.newIntent(getActivity(), eventCard);
            startActivity(intent);
        }
    }
}
