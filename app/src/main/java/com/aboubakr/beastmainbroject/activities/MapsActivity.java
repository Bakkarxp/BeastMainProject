package com.aboubakr.beastmainbroject.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.aboubakr.beastmainbroject.R;
import com.aboubakr.beastmainbroject.entities.RushEvent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



import butterknife.BindView;
import butterknife.ButterKnife;


public class MapsActivity extends BaseActivity {
    @BindView(R.id.activity_map_rush_name)
    TextView rushName;

    @BindView(R.id.activity_map_rush_date)
    TextView rushDate;

    @BindView(R.id.activity_map_rush_time)
    TextView rushTime;

    @BindView(R.id.activity_map_rush_description)
    TextView rushDescription;

    @BindView(R.id.activity_map_rush_address)
    TextView rushLocation;

    private GoogleApiClient googleApiClient;
    private GoogleMap googleMap;
    private RushEvent rushEvent;

    public static final String RUSH_EVENT_INFO = "RUSH_EVENT_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        ButterKnife.bind(this);

        rushEvent = getIntent().getParcelableExtra(RUSH_EVENT_INFO);
        rushName.setText(rushEvent.getEventName());
        rushDate.setText(rushEvent.getEventDate());
        rushTime.setText(rushEvent.getEventTime());
        rushDescription.setText(rushEvent.getEventDescription());
        rushLocation.setText(rushEvent.getEventLocation());

        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(@Nullable Bundle bundle) {
                        updateUI();
                    }

                    @Override
                    public void onConnectionSuspended(int i) {

                    }
                }).build();
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.activity_map_googleMap);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap map) {
                googleMap = map;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        googleApiClient.disconnect();
    }

    private void updateUI() {
        LatLng rushEventPoint = new LatLng(rushEvent.getEventLatitude(), rushEvent.getEventLongitude());

        MarkerOptions rushEventMarker = new MarkerOptions()
                .position(rushEventPoint)
                .title("Rush Event Location")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

        googleMap.clear();
        googleMap.addMarker(rushEventMarker);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rushEventPoint, 15));

    }

    public static Intent newIntent(Context context, RushEvent rushEvent) {
        Intent intent = new Intent(context, MapsActivity.class);
        intent.putExtra(RUSH_EVENT_INFO, rushEvent);
        return intent;
    }
}
