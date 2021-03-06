package com.aboubakr.beastmainbroject.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.aboubakr.beastmainbroject.R;
import com.aboubakr.beastmainbroject.entities.Brother;
import com.aboubakr.beastmainbroject.fragments.AboutUsFragment;
import com.aboubakr.beastmainbroject.fragments.BrotherDetailFragment;
import com.aboubakr.beastmainbroject.fragments.MeetABroFragment;
import com.aboubakr.beastmainbroject.fragments.RushFragment;

public class PracticeActivity extends BaseActivity {
    public static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.activity_practice_fragment_container);

        if(fragment == null){
           fragment = new RushFragment();
           fragmentManager.beginTransaction()
                   .add(R.id.activity_practice_fragment_container,fragment)
                   .commit();

        }

    }
    public static Intent newIntent(Context context, Brother brother) {
        Intent intent = new Intent(context, PracticeActivity.class);
        intent.putExtra(BROTHER_EXTRA_INFO, brother);
        return intent;
    }
}
