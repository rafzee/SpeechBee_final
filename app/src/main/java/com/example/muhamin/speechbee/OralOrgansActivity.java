package com.example.muhamin.speechbee;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class OralOrgansActivity extends AppCompatActivity {
    private ImageView img, sound;
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
                        textToSpeech.setSpeechRate(0.80f);
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
                        toSpeechBangla.setSpeechRate(0.80f);
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
                        textToSpeech.setSpeechRate(0.80f);
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
                        toSpeechBangla.setSpeechRate(0.80f);
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
        setContentView(R.layout.activity_oral_organs);
        img = findViewById(R.id.imageView_oral);
        oral_tv = findViewById(R.id.english_name);
        im1 = findViewById(R.id.go_next);
        im2 = findViewById(R.id.go_back);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.US);
                    textToSpeech.setSpeechRate(0.80f);
                }
            }
        });

        toSpeechBangla = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    toSpeechBangla.setLanguage(new Locale("bn_IN"));
                    toSpeechBangla.setSpeechRate(0.80f);
                    //toSpeechBangla.setVoice()
                }
            }
        });
        oral_tv2 = findViewById(R.id.bangla_name);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnt++;
                if (cnt == 5) cnt = 1;
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

        /*sound = findViewById(R.id.soundBtn);

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech.speak(oral_tv.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });
*/
        oral_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech.speak(oral_tv.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        oral_tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSpeechBangla.speak(oral_tv2.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
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
                img.setImageResource(R.drawable.tongue);
                oral_tv.setText("TONGUE");
                oral_tv2.setText("জিহ্বা");
                textToSpeech.speak("TONGUE", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak("জিহ্বা", TextToSpeech.QUEUE_FLUSH, null);
                //oral_tv.setEnabled(false);
                break;
            case 2:
                img.setImageResource(R.drawable.teeth);
                oral_tv.setText("TEETH");
                oral_tv2.setText("দাঁত");
                textToSpeech.speak("TEETH", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak("দাঁত", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 3:
                img.setImageResource(R.drawable.gum);
                oral_tv.setText("GUM");
                oral_tv2.setText("মাড়ি");
                textToSpeech.speak("GUM", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak("মাড়ি", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 4:
                img.setImageResource(R.drawable.body_6);
                oral_tv.setText("LIPS");
                oral_tv2.setText("ঠোঁট");
                textToSpeech.speak("Lips", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak("ঠোঁট", TextToSpeech.QUEUE_FLUSH, null);
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
