package com.example.muhamin.speechbee;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_TIME = 1500;
    private TextView tv1, tv2, tv3;
    private ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tv1 = findViewById(R.id.lets);
        tv2 = findViewById(R.id.from);
        tv3 = findViewById(R.id.speech);
        im = findViewById(R.id.bee);
        Log.d("haymen", "slpash_1");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                Log.d("haymen", "slpash");
                startActivity(i);
                finish();
            }
        },SPLASH_TIME);
    }
}
