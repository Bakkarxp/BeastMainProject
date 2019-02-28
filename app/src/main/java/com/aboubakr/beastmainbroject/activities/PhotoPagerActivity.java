package com.aboubakr.beastmainbroject.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.aboubakr.beastmainbroject.R;
import com.aboubakr.beastmainbroject.entities.EventCard;
import com.aboubakr.beastmainbroject.entities.EventPicture;

import com.aboubakr.beastmainbroject.fragments.EventPhotoFragment;
import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.aboubakr.beastmainbroject.services.EventPhotoServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PhotoPagerActivity extends  BaseActivity {
    private ArrayList<EventPicture> eventPictures;

    @BindView(R.id.activity_event_photo_pager_viewpager)
    ViewPager viewPager;

    public static final String EXTRA_CARD_INFO = "EXTRA_CARD_INFO";

    public static Intent newIntent(Context context, EventCard eventCard) {
        Intent intent = new Intent(context, PhotoPagerActivity.class);
        intent.putExtra(EXTRA_CARD_INFO, eventCard.getEventId());
        return intent;
    }

    @Subscribe
    public void getCommunityPictures(EventPhotoServices.SearchCommunityPhotoResponse response) {
        eventPictures.clear();
        eventPictures.addAll(response.communityPhotos);
//        viewPager.getAdapter().notifyDataSetChanged();
    }

    @Subscribe
    public void getBrotherhoodPictures(EventPhotoServices.SearchBrotherHoodPhotoResponse response) {
        eventPictures.clear();
        eventPictures.addAll(response.brotherHoodPhotos);
//        viewPager.getAdapter().notifyDataSetChanged();
    }


    @Subscribe
    public void getSocialPictures(EventPhotoServices.SearchSocialPhotoResponse response) {
        eventPictures.clear();
        eventPictures.addAll(response.socialPhotos);
//        viewPager.getAdapter().notifyDataSetChanged();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_photo_pager);
        ButterKnife.bind(this);
        eventPictures = new ArrayList<>();
        int cardIndex = getIntent().getIntExtra(EXTRA_CARD_INFO, 0);
        switch (cardIndex) {
            case 1:
                bus.post(new EventPhotoServices.SearchCommunityPhotoRequest(BeastApplication.FIREBASE_EVENT_PICTURES_COMMUNITY));
                break;
            case 3:
                bus.post(new EventPhotoServices.SearchBrotherHoodPhotoRequest(BeastApplication.FIREBASE_EVENT_PICTURES_BROTHERHOOD));
                break;
            case 5:
                bus.post(new EventPhotoServices.SearchSocialPhotoRequest(BeastApplication.FIREBASE_EVENT_PICTURES_SOCIAL));
                break;
        }
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                EventPicture eventPicture = eventPictures.get(position);
                return EventPhotoFragment.newInstance(eventPicture);
            }

            @Override
            public int getCount() {
                return eventPictures.size();
            }
        });
    }
}
