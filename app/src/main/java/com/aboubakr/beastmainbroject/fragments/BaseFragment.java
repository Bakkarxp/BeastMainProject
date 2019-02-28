package com.aboubakr.beastmainbroject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.squareup.otto.Bus;

public class BaseFragment extends Fragment {
    protected BeastApplication appliction;
    protected Bus bus;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appliction = (BeastApplication)getActivity().getApplication();
        bus = appliction.getBus();
        bus.register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}
