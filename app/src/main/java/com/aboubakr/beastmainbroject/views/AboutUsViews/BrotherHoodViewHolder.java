package com.aboubakr.beastmainbroject.views.AboutUsViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aboubakr.beastmainbroject.R;
import com.aboubakr.beastmainbroject.entities.EventCard;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrotherHoodViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.list_event_card_eventDescription)
    TextView eventDescription;

    @BindView(R.id.list_event_card_progressBar)
    ProgressBar progressBar;

    @BindView(R.id.list_event_card_imageView)
    ImageView eventImage;

    @BindView(R.id.list_event_card_eventType)
    ImageView eventType;

    @BindView(R.id.list_event_card_eventName)
    TextView eventName;


    public BrotherHoodViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void populate(Context context, EventCard eventCard) {
        itemView.setTag(eventCard);
        eventName.setText(eventCard.getEventName());
        eventDescription.setText(eventCard.getEventDescription());

        if (!eventCard.isVideo()) {
            eventType.setImageResource(R.mipmap.camera);
        } else {
            eventType.setImageResource(R.mipmap.video);
        }

        Picasso.with(context).load(eventCard.getEventImage())
                .fit()
                .centerCrop()
                .into(eventImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
