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
    private TextView oral_tv, oral_tv2,oral_tv3;
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
        if (textToSpeech1 == null) {
            textToSpeech1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i != TextToSpeech.ERROR) {
                        textToSpeech1.setLanguage(Locale.US);
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
        if (textToSpeech1 == null) {
            textToSpeech1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i != TextToSpeech.ERROR) {
                        textToSpeech1.setLanguage(Locale.US);
                    }
                }
            });

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour);
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
        textToSpeech1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    textToSpeech1.setLanguage(Locale.US);
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
        oral_tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textToSpeech1.speak(oral_tv3.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
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
                img.setImageResource(R.drawable.red);
                oral_tv.setText("RED");
                oral_tv2.setText("লাল");
                textToSpeech.speak("RED", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak("লাল", TextToSpeech.QUEUE_FLUSH, null);
                //oral_tv.setEnabled(false);
                break;
            case 2:
                img.setImageResource(R.drawable.blue);
                oral_tv.setText("BLUE");
                oral_tv2.setText("নীল");
                textToSpeech.speak("BLUE", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak("নীল", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 3:
                img.setImageResource(R.drawable.green);
                oral_tv.setText("GREEN");
                oral_tv2.setText("সবুজ");
                textToSpeech.speak("GREEN", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak("সবুজ", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 4:
                img.setImageResource(R.drawable.orange);
                oral_tv2.setText("কমলা");
                oral_tv.setText("ORANGE");
                textToSpeech.speak("ORANGE", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak("কমলা", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 5:
                img.setImageResource(R.drawable.yellow);
                oral_tv.setText("YELLOW");
                oral_tv2.setText("হলুদ");
                textToSpeech.speak("YELLOW", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak("হলুদ", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 6:
                img.setImageResource(R.drawable.pink);
                oral_tv.setText("PINK");
                oral_tv2.setText("গোলাপী");
                textToSpeech.speak("PINK", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak("গোলাপী", TextToSpeech.QUEUE_FLUSH, null);
                break;

            case 7:
                img.setImageResource(R.drawable.black);
                oral_tv.setText("BLACK");
                oral_tv2.setText("কালো");
                textToSpeech.speak("BLACK", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak("কালো", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 8:
                img.setImageResource(R.drawable.white);
                oral_tv.setText("WHITE");
                oral_tv2.setText("সাদা");
                textToSpeech.speak("WHITE", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak("সাদা", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 9:
                img.setImageResource(R.drawable.purple);
                oral_tv.setText("PURPLE");
                oral_tv2.setText("ঠোঁট");
                textToSpeech.speak("PURPLE", TextToSpeech.QUEUE_FLUSH, null);
                toSpeechBangla.speak("নীল", TextToSpeech.QUEUE_FLUSH, null);
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






