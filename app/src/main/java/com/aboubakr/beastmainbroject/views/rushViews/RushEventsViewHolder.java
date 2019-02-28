package com.aboubakr.beastmainbroject.views.rushViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.aboubakr.beastmainbroject.R;
import com.aboubakr.beastmainbroject.entities.RushEvent;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RushEventsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.list_rush_event_name)
    TextView eventName;

    @BindView(R.id.list_rush_event_date)
    TextView eventDate;

    @BindView(R.id.list_rush_event_location)
    TextView eventLocation;

    @BindView(R.id.list_rush_event_time)
    TextView eventTime;


    public RushEventsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public void populate(RushEvent rushEvent) {

        itemView.setTag(rushEvent);
        eventName.setText(rushEvent.getEventName());
        eventDate.setText(rushEvent.getEventDate());
        eventLocation.setText(rushEvent.getEventLocation());
        eventTime.setText(rushEvent.getEventTime());
    }
}
