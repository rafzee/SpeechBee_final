package com.example.muhamin.speechbee;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MannersActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_manners);
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
                if (cnt == 8) cnt = 1;
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
                textToSpeech1.speak(oral_tv2.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
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
                img.setImageResource(R.drawable.man1);
                oral_tv.setText("Hello");
                oral_tv2.setText("Say Hello to Everyone");
                textToSpeech.speak("Hello", TextToSpeech.QUEUE_FLUSH, null);
                textToSpeech1.speak("Say Hello to Everyone", TextToSpeech.QUEUE_FLUSH, null);
                //oral_tv.setEnabled(false);
                break;
            case 2:
                img.setImageResource(R.drawable.man2);
                oral_tv.setText("Assalamualaikum");
                oral_tv2.setText(" Greet everyone with Salam");
                textToSpeech.speak("Assalam mualaikum", TextToSpeech.QUEUE_FLUSH, null);
                textToSpeech1.speak("Greet everyone with Salam", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 3:
                img.setImageResource(R.drawable.man3);
                oral_tv.setText("Washing is important");
                oral_tv2.setText("Wash your hands before every meal");
                textToSpeech.speak("Wash your hands", TextToSpeech.QUEUE_FLUSH, null);
                textToSpeech1.speak("Wash your hands before every meal", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 4:
                img.setImageResource(R.drawable.man4);
                oral_tv2.setText("Talk politely");
                oral_tv.setText("Donot make loud noise");
                textToSpeech.speak("Donot make loud noise", TextToSpeech.QUEUE_FLUSH, null);
                textToSpeech1.speak("Talk politely", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 5:
                img.setImageResource(R.drawable.man5);
                oral_tv.setText("Helping others");
                oral_tv2.setText("Always Help others");
                textToSpeech.speak("Helping others", TextToSpeech.QUEUE_FLUSH, null);
                textToSpeech1.speak("Always Help others", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 6:
                img.setImageResource(R.drawable.man6);
                oral_tv.setText("Thanking others");
                oral_tv2.setText("Say thank you to the one who helped you");
                textToSpeech.speak("Thanking others", TextToSpeech.QUEUE_FLUSH, null);
                textToSpeech1.speak("Say thank you to the one who helped you", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 7:
                img.setImageResource(R.drawable.man7);
                oral_tv.setText("Be Sorry");
                oral_tv2.setText("Say sorry to the one you had hurt");
                textToSpeech.speak("Be Sorry", TextToSpeech.QUEUE_FLUSH, null);
                textToSpeech1.speak("Say sorry to the one you had hurt", TextToSpeech.QUEUE_FLUSH, null);
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
