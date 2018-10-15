package com.example.muhamin.speechbee;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class ColourActivity extends AppCompatActivity {
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
                if (cnt == 10) cnt = 1;
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
                img.setImageResource(R.drawable.red);
                oral_tv.setText("RED");
                oral_tv2.setText("চোখ");
                textToSpeech.speak("RED", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak("চোখ", TextToSpeech.QUEUE_FLUSH, null);
                //oral_tv.setEnabled(false);
                break;
            case 2:
                img.setImageResource(R.drawable.blue);
                oral_tv.setText("BLUE");
                oral_tv2.setText("নাক");
                textToSpeech.speak("BLUE", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 3:
                img.setImageResource(R.drawable.green);
                oral_tv.setText("GREEN");
                oral_tv2.setText("গলা");
                textToSpeech.speak("GREEN", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 4:
                img.setImageResource(R.drawable.orange);
                oral_tv2.setText("চুল");
                oral_tv.setText("ORANGE");
                textToSpeech.speak("ORANGE", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 5:
                img.setImageResource(R.drawable.yellow);
                oral_tv.setText("YELLOW");
                oral_tv2.setText("কান");
                textToSpeech.speak("YELLOW", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 6:
                img.setImageResource(R.drawable.pink);
                oral_tv.setText("PINK");
                oral_tv2.setText("ঠোঁট");
                textToSpeech.speak("PINK", TextToSpeech.QUEUE_FLUSH, null);
                break;

            case 7:
                img.setImageResource(R.drawable.black);
                oral_tv.setText("BLACK");
                oral_tv2.setText("ঠোঁট");
                textToSpeech.speak("BLACK", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 8:
                img.setImageResource(R.drawable.white);
                oral_tv.setText("WHITE");
                oral_tv2.setText("ঠোঁট");
                textToSpeech.speak("WHITE", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 9:
                img.setImageResource(R.drawable.purple);
                oral_tv.setText("PURPLE");
                oral_tv2.setText("ঠোঁট");
                textToSpeech.speak("PURPLE", TextToSpeech.QUEUE_FLUSH, null);
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
}






