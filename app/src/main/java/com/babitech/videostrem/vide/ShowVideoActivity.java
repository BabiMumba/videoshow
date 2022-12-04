package com.babitech.videostrem.vide;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.babitech.videostrem.R;

public class ShowVideoActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strem);

        MediaController mediaController = new MediaController(this);
        videoView = findViewById(R.id.vide_view);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        Uri uri = Uri.parse("");
        videoView.setVideoURI(uri);
        videoView.start();


    }
}