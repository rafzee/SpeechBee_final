package com.example.muhamin.speechbee;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class PrepositionActivity extends AppCompatActivity {
    private ImageView img;
    private ImageButton im1, im2;
    private TextView oral_tv, oral_tv2;
    private int cnt = 1;
    private TextToSpeech textToSpeech,textToSpeech1,toSpeechBangla;

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
        setContentView(R.layout.activity_preposition);
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
        textToSpeech1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    textToSpeech1.setLanguage(Locale.US);
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
                img.setImageResource(R.drawable.in);
                oral_tv.setText("IN");
               oral_tv2.setText("The cat is in the box");
                textToSpeech.speak("in", TextToSpeech.QUEUE_FLUSH, null);
                textToSpeech1.speak("The cat is in the box", TextToSpeech.QUEUE_FLUSH, null);
              //  toSpeechBangla.speak("চোখ", TextToSpeech.QUEUE_FLUSH, null);
                //oral_tv.setEnabled(false);
                break;
            case 2:
                img.setImageResource(R.drawable.on);
                oral_tv.setText("ON");
                oral_tv2.setText("The Dog is on the sofa");
                textToSpeech.speak("on", TextToSpeech.QUEUE_FLUSH, null);
                textToSpeech1.speak("The Dog is on the sofa", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 3:
                img.setImageResource(R.drawable.up);
                oral_tv.setText("UP");
                oral_tv2.setText("The bear is going up");
                textToSpeech.speak("up", TextToSpeech.QUEUE_FLUSH, null);
                textToSpeech1.speak("The bear is going up", TextToSpeech.QUEUE_FLUSH, null);
                break;
            case 4:
                img.setImageResource(R.drawable.down);
                oral_tv.setText("DOWN");
                oral_tv2.setText("They are going down");
                textToSpeech.speak("Down", TextToSpeech.QUEUE_FLUSH, null);
                textToSpeech1.speak("They are going down",TextToSpeech.QUEUE_FLUSH,null);
                break;
            case 5:
                img.setImageResource(R.drawable.under);
                oral_tv.setText("UNDER");
                oral_tv2.setText("The girl is under the table");
                textToSpeech.speak("UNDER", TextToSpeech.QUEUE_FLUSH, null);
                textToSpeech1.speak("The girl is under the table",TextToSpeech.QUEUE_FLUSH,null);
                break;
            case 6:
                img.setImageResource(R.drawable.over);
                oral_tv.setText("OVER");
                oral_tv2.setText("The ship is over the box");
                textToSpeech.speak("over", TextToSpeech.QUEUE_FLUSH, null);
                textToSpeech1.speak("The ship is over the box",TextToSpeech.QUEUE_FLUSH,null);

                break;

            case 7:
                img.setImageResource(R.drawable.between);
                oral_tv.setText("BETWEEN");
                oral_tv2.setText("The bird is between the box");
                textToSpeech.speak("between", TextToSpeech.QUEUE_FLUSH, null);
                textToSpeech1.speak("The bird is between the box",TextToSpeech.QUEUE_FLUSH,null);
                break;
            case 8:
                img.setImageResource(R.drawable.infrontof);
                oral_tv.setText("IN FRONT OF");
                oral_tv2.setText("The apple is in front of the box");
                textToSpeech.speak("in front of", TextToSpeech.QUEUE_FLUSH, null);
                textToSpeech1.speak("The apple is in front of the box",TextToSpeech.QUEUE_FLUSH,null);
                break;
            case 9:
                img.setImageResource(R.drawable.behind);
                oral_tv.setText("BEHIND");
                oral_tv2.setText("The boy is behind the chair");
                textToSpeech.speak("behind", TextToSpeech.QUEUE_FLUSH, null);
                textToSpeech1.speak("The boy is behind the chair",TextToSpeech.QUEUE_FLUSH,null);
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
