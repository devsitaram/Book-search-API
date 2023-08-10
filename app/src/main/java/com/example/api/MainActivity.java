package com.example.api;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    Button btnPlay;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        btnPlay = findViewById(R.id.btnPlay);

        btnPlay.setOnClickListener(v -> {

            String vPath = "android.resource://"+getPackageName()+"/raw/namer_jr";
            Uri videoUri = Uri.parse(vPath);

            String onlinePath = "https://www.google.com/search?q=videos+mpg4&oq=videos+mpg4&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIGCAEQRRhA0gEJMTIxNzlqMGo3qAIAsAIA&sourceid=chrome&ie=UTF-8#fpstate=ive&vld=cid:283f7b34,vid:HdhTBzeVzEM";
            Uri onlineVideo = Uri.parse(onlinePath);

            videoView.setVideoURI(onlineVideo); // video uri set
            videoView.start(); // start the video

            // default button
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);
        });
    }
}