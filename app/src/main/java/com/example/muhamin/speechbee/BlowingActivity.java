package com.example.muhamin.speechbee;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class BlowingActivity extends AppCompatActivity {

    private VideoView v;
    private Uri u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blowing);
        v = findViewById(R.id.video_view);
        u = Uri.parse("android.resources://" + getPackageName() + "/" + R.raw.blow_1);
        v.setVideoURI(u);
        v.requestFocus();
        v.start();
    }
}
