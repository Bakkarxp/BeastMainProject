package com.aboubakr.beastmainbroject.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.aboubakr.beastmainbroject.R;
import com.aboubakr.beastmainbroject.entities.EventCard;
import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private String videoUrl;

    public static final String EXTRA_VIDEO_INFO = "EXTRA_VIDEO_INFO";

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_youtube);
        videoUrl = getIntent().getStringExtra(EXTRA_VIDEO_INFO);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.activity_youtube_player_View);
        youTubePlayerView.initialize(BeastApplication.YOUTUBE_API_KEY, this);
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(videoUrl);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    public static Intent newIntent(Context context, EventCard event) {
        Intent intent = new Intent(context, YoutubeActivity.class);
        intent.putExtra(EXTRA_VIDEO_INFO, event.getYoutubeEnding());
        return intent;
    }
}
