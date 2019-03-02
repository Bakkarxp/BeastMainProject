package com.aboubakr.beastmainbroject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aboubakr.beastmainbroject.R;
import com.aboubakr.beastmainbroject.activities.BaseActivity;
import com.aboubakr.beastmainbroject.activities.BrotherPagerActivity;
import com.aboubakr.beastmainbroject.entities.Brother;
import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.aboubakr.beastmainbroject.services.BrotherServices;
import com.aboubakr.beastmainbroject.views.MeetABroViews.MeetABroAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class MeetABroFragment extends BaseFragment implements MeetABroAdapter.OnBrotherClickedListener {
    // used for debugging
    private final String LOG_TAG = MeetABroFragment.class.getSimpleName();
    private final int BROTHERS_PER_ROW = 4;

    private MeetABroAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Brother> brothers;

    // create and return new instance of this fragment
    public static MeetABroFragment newInstance() {
        return new MeetABroFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_meet_a_bro, container, false);

        adapter = new MeetABroAdapter((BaseActivity) getActivity(), this);

        // get reference to brothers array present inside the MeetABroAdapter class
        brothers = adapter.getBrothers();
        recyclerView = rootView.findViewById(R.id.fragment_meet_a_bro_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        setUpAdapter();
        //getBrothers(brothers);
        // posting event with BrotherSearchRequest object
        bus.post(new BrotherServices.BrotherSearchRequest(BeastApplication.FIREBASE_BROTHERS_REFERENCE));
        return rootView;
    }

    private void setUpAdapter() {
        // if fragment is added to the activity, setup  the adapter
        if (isAdded()) {
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void OnBrotherClicked(Brother brother) {
        //Log.i(LOG_TAG, brother.getBrotherName()+" was clicked");
//        Intent intent = PracticeActivity.newIntent(getActivity(), brother);
        Intent intent = BrotherPagerActivity.newIntent(getActivity(), brother);

        startActivity(intent);


    }

    // subscribe to the event with BrotherSearchResponse
    // when event with BrotherSearchRequest is posted, this will handle it
    @Subscribe
    public void getBrothers(BrotherServices.BrotherSearchResponse response) {
        // add elements to the brothers array inside MeetABroAdapter class
//        int oldSize = brothers.size();
//        brothers.clear();
//        adapter.notifyItemRangeRemoved(0, oldSize);
//        brothers.addAll(response.brothers);
//        adapter.notifyItemRangeChanged(0,brothers.size());
        int oldSize = brothers.size();
        if (oldSize == 0) {
            brothers.clear();
            adapter.notifyItemRangeRemoved(0, oldSize);
            brothers.addAll(response.brothers);
            adapter.notifyItemChanged(0, brothers.size());
        }
    }
}
