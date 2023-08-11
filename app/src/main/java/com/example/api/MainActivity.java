package com.example.api;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
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
            // Local video path
            String vPath = "android.resource://" + getPackageName() + "/raw/neymar";
            Uri videoUri = Uri.parse(vPath);

            // Online video path
            String onlinePath = "https://www.example.com/path-to-your-online-video.mp4";
            Uri onlineVideo = Uri.parse(onlinePath);

            // Set the video URI and start playback
//            videoView.setVideoURI(onlineVideo);
            videoView.setVideoURI(videoUri);
            videoView.start();

            // Set up media controller
            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            mediaController.setAnchorView(videoView);

            // if video is play when less then 60 seconds
            videoView.setOnPreparedListener(mp -> {
                int duration = mp.getDuration(); // Duration of the video in milliseconds
                int maxDuration = 60000; // Maximum duration of 1 minute in milliseconds

                if (duration > maxDuration) {
                    videoView.seekTo(0); // Start from the beginning
                    videoView.start();   // Start playback
                    videoView.postDelayed(() -> videoView.pause(), maxDuration); // Pause after 1 minute
                    Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
                } else {
                    videoView.start(); // Start playback normally
                }
            });
        });
    }
}