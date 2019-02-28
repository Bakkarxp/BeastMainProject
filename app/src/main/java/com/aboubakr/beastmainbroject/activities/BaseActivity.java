package com.aboubakr.beastmainbroject.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.squareup.otto.Bus;

public class BaseActivity extends AppCompatActivity {
    protected BeastApplication appliction;
    protected Bus bus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appliction = (BeastApplication) getApplication();
        bus = appliction.getBus();
        bus.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}
