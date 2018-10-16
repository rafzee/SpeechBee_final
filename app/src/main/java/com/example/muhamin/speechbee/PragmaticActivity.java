package com.example.muhamin.speechbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PragmaticActivity extends AppCompatActivity {
 Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pragmatic);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PragmaticActivity.this, MannersActivity.class));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PragmaticActivity.this, PermissionActivity.class));
            }
        });
    }
}
