package com.aboubakr.beastmainbroject.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.aboubakr.beastmainbroject.fragments.AboutUsFragment;
import com.aboubakr.beastmainbroject.fragments.MeetABroFragment;
import com.aboubakr.beastmainbroject.fragments.RushFragment;

public class MainActivityViewPagerAdapter extends FragmentStatePagerAdapter {

    public MainActivityViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment returnFragment;
        switch (position){
            case 0:
                returnFragment = AboutUsFragment.newInstance();
                break;
            case 1:
                returnFragment = MeetABroFragment.newInstance();
                break;
            case 2:
                returnFragment = RushFragment.newInstance();
                break;
            default:
                return null;
        }
        return returnFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title;
        switch (position){
            case 0:
                title = "About Us";
                break;
            case 1:
                title = "Meet a Bro!";
                break;
            case 2:
                title = "Rush";
                break;
            default:
                return null;
        }
        return title;

    }
}
