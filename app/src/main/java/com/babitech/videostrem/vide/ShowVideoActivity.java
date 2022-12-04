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

        String lien = "https://firebasestorage.googleapis.com/v0/b/videoshow-6801b.appspot.com/o/myvideos%2F1670119056829.mp4?alt=media&token=55180769-ad0a-401a-a0fd-ba9b2bd0905f";
        String lien2 = "https://d286.d2mefast.net/tb/d/a7/whitney_houston_i_look_to_you_h264_10418.mp4?play";

        Uri uri = Uri.parse(lien2);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();


    }
}