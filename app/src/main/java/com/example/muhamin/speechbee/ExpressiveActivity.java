package com.example.muhamin.speechbee;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class ExpressiveActivity extends AppCompatActivity {

    private ImageView img;
    private ImageButton im1, im2;
    private TextView oral_tv, oral_tv2;
    private int cnt = 1;
    private TextToSpeech textToSpeech,textToSpeech1, toSpeechBangla;

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
        if (textToSpeech1 == null) {
            textToSpeech1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i != TextToSpeech.ERROR) {
                        textToSpeech1.setLanguage(Locale.US);
                        textToSpeech1.setSpeechRate(0.80f);
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
        if (textToSpeech1 == null) {
            textToSpeech1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i != TextToSpeech.ERROR) {
                        textToSpeech1.setLanguage(Locale.US);
                        textToSpeech1.setSpeechRate(0.80f);
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
        setContentView(R.layout.activity_expressive);
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
        textToSpeech1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    textToSpeech1.setLanguage(Locale.US);
                    textToSpeech1.setSpeechRate(0.80f);
                }
            }
        });
        oral_tv2 = findViewById(R.id.bangla_name);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnt++;
                if (cnt == 4) cnt = 1;
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
        if (textToSpeech1 != null) {
            textToSpeech1.stop();
            textToSpeech1.shutdown();
        }
        super.onPause();
    }

    private void setImage(int idx) {

        switch (idx) {
            case 1:
                img.setImageResource(R.drawable.exp1);
                oral_tv.setText("Now how many fingers do u see?");
                oral_tv2.setText("bangla");
                textToSpeech.speak("Now how many fingers do u see?", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak(" ", TextToSpeech.QUEUE_FLUSH, null);
                //oral_tv.setEnabled(false);
                break;
            case 2:
                img.setImageResource(R.drawable.exp2);
                oral_tv.setText("How many fingers do u see?");
                oral_tv2.setText("  ");
                textToSpeech.speak("How many fingers do u see?", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak(" ", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 3:
                img.setImageResource(R.drawable.exp3);
                oral_tv.setText("How many apples are there?");
                oral_tv2.setText(" ");
                textToSpeech.speak("How many apples are there?", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak(" ", TextToSpeech.QUEUE_FLUSH, null);
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
