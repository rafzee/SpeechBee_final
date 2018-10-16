package com.example.muhamin.speechbee;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class BlowingActivity extends AppCompatActivity {

    private VideoView v;
    private Uri u;
    private int position = 0;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blowing);
        v = findViewById(R.id.video_view);

        if (mediaController == null) {
            mediaController = new MediaController(this);
            mediaController.setAnchorView(v);
            v.setMediaController(mediaController);
        }

        try {
            v.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.blow_1));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        v.requestFocus();
        v.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                v.seekTo(position);
                if (position == 0) {
                    v.start();
                }

                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                        mediaController.setAnchorView(v);
                    }
                });
            }
        });

        v.requestFocus();

        try {
            v.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.blow_2));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        v.requestFocus();
        v.start();



    }




    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("CurrentPosition", v.getCurrentPosition());
        v.pause();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt("CurrentPosition");
        v.seekTo(position);
    }

}
