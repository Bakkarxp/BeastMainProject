package com.aboubakr.beastmainbroject.views.rushViews;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.aboubakr.beastmainbroject.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RushFooterViewHolder extends RecyclerView.ViewHolder {
    private static final String FACEBOOK_PACKAGE = "com.facebook.katana";
    private static final String TWITTER_PACKAGE = "com.twitter.android";
    private static final String INSTAGRAM_PACKAGE = "com.instagram.android";
    private static final String SNAPCHAT_PACKAGE = "?";

    @BindView(R.id.footer_rush_fragment_twitter)
    ImageView twitter;

    @BindView(R.id.footer_rush_fragment_facebook)
    ImageView facebook;

    @BindView(R.id.footer_rush_fragment_snapchat)
    ImageView snapchat;

    @BindView(R.id.footer_rush_fragment_instagram)
    ImageView instagram;


    public RushFooterViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                try {
                    // using the facebook app (if it exists on user's device)
                    view.getContext().getPackageManager().getPackageInfo(FACEBOOK_PACKAGE, 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/605083229565089"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    // using the web browser
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/officialdjkhaled"));
                }
                view.getContext().startActivity(intent);
            }
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                try {
                    // using the facebook app (if it exists on user's device)
                    view.getContext().getPackageManager().getPackageInfo(TWITTER_PACKAGE, 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=" + "27673684"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    // using the web browser
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/djkhaled"));
                }
                view.getContext().startActivity(intent);
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                try {
                    // using the facebook app (if it exists on user's device)
                    view.getContext().getPackageManager().getPackageInfo(INSTAGRAM_PACKAGE, 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/_u/djkhaled"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    // using the web browser
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/djkhaled"));
                }
                view.getContext().startActivity(intent);
            }
        });

        snapchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                try {
                    // using the facebook app (if it exists on user's device)
                    view.getContext().getPackageManager().getPackageInfo(SNAPCHAT_PACKAGE, 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://snapchat.com/add/" + "djkhaled"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    // using the web browser
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://snapchat.com/add/" + "djkhaled"));
                }
                view.getContext().startActivity(intent);
            }
        });
    }

    public void populate(Context context) {
        Picasso.with(context).load(R.drawable.face).into(facebook);
        Picasso.with(context).load(R.drawable.snap).into(snapchat);
        Picasso.with(context).load(R.drawable.twit).into(twitter);
        Picasso.with(context).load(R.drawable.insta).into(instagram);
    }


}
