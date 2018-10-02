package com.example.muhamin.speechbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TherapyLevelActivity extends AppCompatActivity {
 Button b3, b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapy_level);



        b1 = findViewById(R.id.btn1);
        b3=findViewById(R.id.btn3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TherapyLevelActivity.this, ReceptiveLevelsActivity.class);
                startActivity(intent);
                }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TherapyLevelActivity.this, OralActivity.class);
            }
        });
    }
}
