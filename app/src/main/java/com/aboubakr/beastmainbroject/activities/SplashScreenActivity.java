package com.aboubakr.beastmainbroject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class SplashScreenActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this,MainActivity.class));
        // calling finish the activity no longer exists
        // and user con not go back to it using back button
        finish();
    }
}
