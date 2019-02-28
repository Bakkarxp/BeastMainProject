package com.aboubakr.beastmainbroject.views.MeetABroViews;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.aboubakr.beastmainbroject.R;
import com.aboubakr.beastmainbroject.entities.Brother;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


//A ViewHolder describes an item view and metadata about its place within the RecyclerView.
// A ViewHolder object stores each of the component views inside the tag field of the Layout,
// so you can immediately access them without the need to look them up repeatedly. First,
// you need to create a class to hold your exact set of views.
// the class interface for the item layout



public class MeetABroViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.list_meet_a_bro_imageView)
    ImageView brotherPic;
    @BindView(R.id.list_meet_a_bro_progress)
    ProgressBar brotherProgressBar;


    public MeetABroViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(Context context, Brother brother){
        itemView.setTag(brother);
        Picasso.with(context)
                .load(brother.getBrotherPicture())
                .fit()
                .centerCrop()
                .into(brotherPic, new Callback() {
                    @Override
                    public void onSuccess() {
                        brotherProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
