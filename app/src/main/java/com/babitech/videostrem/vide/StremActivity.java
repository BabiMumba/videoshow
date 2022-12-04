package com.babitech.videostrem.vide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.babitech.videostrem.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class StremActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_video);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);


    }
}