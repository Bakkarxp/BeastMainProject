package com.aboubakr.beastmainbroject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aboubakr.beastmainbroject.R;
import com.aboubakr.beastmainbroject.activities.BaseActivity;
import com.aboubakr.beastmainbroject.activities.CampusMapActivity;

import com.aboubakr.beastmainbroject.activities.MapsActivity;
import com.aboubakr.beastmainbroject.entities.RushEvent;
import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.aboubakr.beastmainbroject.services.RushEventServices;
import com.aboubakr.beastmainbroject.views.rushViews.RushEventAdapter;
import com.aboubakr.beastmainbroject.views.rushViews.RushItem;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class RushFragment extends BaseFragment implements RushEventAdapter.RushEventListener{

    private RushEventAdapter adapter;
    private ArrayList<RushEvent> communityServiceRushEvents;
    private ArrayList<RushEvent> socialRushEvents;

    private RushItem communityHeaderRushItem;
    private RushItem socialHeaderRushItem;

    private RecyclerView recyclerView;

    public static RushFragment newInstance(){
        return  new RushFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rush,container,false);

        adapter = new RushEventAdapter((BaseActivity) getActivity(), this);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_rush_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        socialRushEvents = new ArrayList<>();
        communityServiceRushEvents = new ArrayList<>();

        List<RushItem> data = adapter.getData();

        communityHeaderRushItem = new RushItem(RushEventAdapter.VIEW_TYPE_LIST_EXPANDABLE_LIST_HEADER, "Community Service Rush Events");
        communityHeaderRushItem.invisibleChildren = new ArrayList<>();

        socialHeaderRushItem = new RushItem(RushEventAdapter.VIEW_TYPE_LIST_EXPANDABLE_LIST_HEADER, "Social Rush Events");
        socialHeaderRushItem.invisibleChildren = new ArrayList<>();

        bus.post(new RushEventServices.RushCommunityServiceServicesSearchRequest(BeastApplication.FIREBASE_RUSH_COMMUNITY));
        bus.post(new RushEventServices.RushSocialServicesSearchRequest(BeastApplication.FIREBASE_RUSH_SOCIAL));

        setUpAdapter();

        data.add(communityHeaderRushItem);
        data.add(socialHeaderRushItem);

        return  rootView;
    }
    private void setUpAdapter() {
        if (isAdded()) {
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void OnRushEventClicked(RushEvent rushEvent) {
        if (!rushEvent.isOnCampus()) {
            Intent intent = MapsActivity.newIntent(getActivity(), rushEvent);
            startActivity(intent);
        } else {
            Intent intent = CampusMapActivity.newIntent(getActivity(), rushEvent);
            startActivity(intent);
        }
    }

    @Subscribe
    public void getCommunityServiceRushEvents(RushEventServices.RushCommunityServiceServicesSearchResponse response) {
        communityServiceRushEvents.clear();
        communityServiceRushEvents.addAll(response.communityServiceRushEvents);
        for (RushEvent rushEvent : communityServiceRushEvents) {
            communityHeaderRushItem.invisibleChildren.add(new RushItem(RushEventAdapter.VIEW_TYPE_LIST_EXPANDABLE_LIST_CHILD, rushEvent));
        }
    }

    @Subscribe
    public void getSocialRushEvents(RushEventServices.RushSocialServicesSearchResponse response) {
        socialRushEvents.clear();
        socialRushEvents.addAll(response.socialRushEvents);
        for (RushEvent rushEvent : socialRushEvents) {
            socialHeaderRushItem.invisibleChildren.add(new RushItem(RushEventAdapter.VIEW_TYPE_LIST_EXPANDABLE_LIST_CHILD, rushEvent));
        }
    }

}
