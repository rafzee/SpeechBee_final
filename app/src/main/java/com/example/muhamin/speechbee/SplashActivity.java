package com.example.muhamin.speechbee;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;


public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_TIME = 1500;
    private TextView tv1, tv2, tv3;
    private ImageView im;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /*user = FirebaseAuth.getInstance().getCurrentUser();

        if(user != null) {
            Intent i = new Intent(getApplicationContext(), NavigationHome
                    .class);
            startActivity(i);
            finish();
        }*/

        tv1 = findViewById(R.id.lets);
        tv2 = findViewById(R.id.from);
        tv3 = findViewById(R.id.speech);
        im = findViewById(R.id.bee);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                    Intent i = new Intent(getApplicationContext(), ColourActivity.class);
                    //     Log.d("haymen", "slpash");
                    startActivity(i);
                    finish();
                    return;
                }
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                //     Log.d("haymen", "slpash");
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME);
    }
}
