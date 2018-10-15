package com.example.muhamin.speechbee;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.net.URI;
import java.util.Locale;

public class OralActivity extends AppCompatActivity {


    private ImageView img;
    private ImageButton im1, im2;
    private TextView oral_tv, oral_tv2;
    private int cnt = 1;
    private TextToSpeech textToSpeech, toSpeechBangla;

    @Override
    protected void onRestart() {
        super.onRestart();
        if (textToSpeech == null) {
            textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i != TextToSpeech.ERROR) {
                        textToSpeech.setLanguage(Locale.US);
                    }
                }
            });

        }
        if (toSpeechBangla == null) {
            toSpeechBangla = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i != TextToSpeech.ERROR) {
                        toSpeechBangla.setLanguage(new Locale("bn_IN"));
                    }
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (textToSpeech == null) {
            textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i != TextToSpeech.ERROR) {
                        textToSpeech.setLanguage(Locale.US);
                    }
                }
            });

        }
        if (toSpeechBangla == null) {
            toSpeechBangla = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i != TextToSpeech.ERROR) {
                        toSpeechBangla.setLanguage(new Locale("bn_IN"));
                    }
                }
            });

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

/*

        AlertDialog.Builder b;
        b = new AlertDialog.Builder(this);
        b.setView(getLayoutInflater().inflate(R.layout.start_lesson, null));
        b.setPositiveButton(R.drawable.button_text, )
        b.show();
*/


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oral);
        img = findViewById(R.id.imageView_oral);
        oral_tv = findViewById(R.id.english_name);
        im1 = findViewById(R.id.go_next);
        im2 = findViewById(R.id.go_back);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });

        toSpeechBangla = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    toSpeechBangla.setLanguage(new Locale("bn_IN"));
                }
            }
        });
        oral_tv2 = findViewById(R.id.bangla_name);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnt++;
                if (cnt == 7) cnt = 1;
                setImage(cnt);
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnt--;
                if (cnt == 0) cnt = 1;
                setImage(cnt);
            }
        });

    }

    @Override
    public void onPause() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        if (toSpeechBangla != null) {
            toSpeechBangla.stop();
            toSpeechBangla.shutdown();
        }
        super.onPause();
    }

    private void setImage(int idx) {

        switch (idx) {
            case 1:
                img.setImageResource(R.drawable.body_1);
                oral_tv.setText("Eyes");
                oral_tv2.setText("চোখ");
                textToSpeech.speak("Eyes", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak("চোখ", TextToSpeech.QUEUE_FLUSH, null);
                //oral_tv.setEnabled(false);
                break;
            case 2:
                img.setImageResource(R.drawable.body_2);
                oral_tv.setText("Nose");
                oral_tv2.setText("নাক");
                textToSpeech.speak("Nose", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 3:
                img.setImageResource(R.drawable.body_3);
                oral_tv.setText("Neck");
                oral_tv2.setText("গলা");
                textToSpeech.speak("Neck", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 4:
                img.setImageResource(R.drawable.body_4);
                oral_tv2.setText("চুল");
                oral_tv.setText("Hair");
                textToSpeech.speak("Hair", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 5:
                img.setImageResource(R.drawable.body_5);
                oral_tv.setText("Ear");
                oral_tv2.setText("কান");
                textToSpeech.speak("Ear", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 6:
                img.setImageResource(R.drawable.body_6);
                oral_tv.setText("Lips");
                oral_tv2.setText("ঠোঁট");
                textToSpeech.speak("Lips", TextToSpeech.QUEUE_FLUSH, null);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }

        super.onDestroy();
    }

    //https://codinginflow.com/tutorials/android/firebase-storage-upload-and-retrieve-images/part-6-retrieve-images

}
