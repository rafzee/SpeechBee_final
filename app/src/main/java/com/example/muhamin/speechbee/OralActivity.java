package com.example.muhamin.speechbee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class OralActivity extends AppCompatActivity {

    private StorageReference storageReference;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oral);
        storageReference = FirebaseStorage.getInstance().getReference();
        img = findViewById(R.id.imageView_oral);

        Glide.with(getApplicationContext()).load(storageReference).into(img);
    }

    //https://codinginflow.com/tutorials/android/firebase-storage-upload-and-retrieve-images/part-6-retrieve-images

}
