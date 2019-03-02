package com.aboubakr.beastmainbroject.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.aboubakr.beastmainbroject.R;
import com.aboubakr.beastmainbroject.entities.Brother;
import com.aboubakr.beastmainbroject.fragments.BrotherDetailFragment;
import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.aboubakr.beastmainbroject.services.BrotherServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrotherPagerActivity extends BaseActivity{
    public static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";
    private ArrayList<Brother> brothers;

    @BindView(R.id.activity_brother_pager_viewpager)
    ViewPager brotherViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brother_pager);

        ButterKnife.bind(this);
        brothers = new ArrayList<>();
        bus.post(new BrotherServices.BrotherSearchRequest(BeastApplication.FIREBASE_BROTHERS_REFERENCE));
        brotherViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Brother brother = brothers.get(position);
                return BrotherDetailFragment.newInstance(brother);
            }

            @Override
            public int getCount() {
                return brothers.size();
            }
        });

    }

    @Subscribe
    public void getBrothers(BrotherServices.BrotherSearchResponse response) {
        brothers.clear();
        brothers.addAll(response.brothers);
        brotherViewPager.getAdapter().notifyDataSetChanged();

        Brother brother = getIntent().getParcelableExtra(BROTHER_EXTRA_INFO);
        int brotherId = brother.getBrotherId();
        for (int i = 0; i < brothers.size(); i++) {
            if (brothers.get(i).getBrotherId() == brotherId) {
                brotherViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    public static Intent newIntent(Context context, Brother brother) {
        Intent intent = new Intent(context, BrotherPagerActivity.class);
        intent.putExtra(BROTHER_EXTRA_INFO, brother);
        return intent;
    }
}
