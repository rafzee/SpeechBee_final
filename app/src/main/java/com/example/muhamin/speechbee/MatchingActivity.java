package com.example.muhamin.speechbee;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MatchingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView im1, im2, im3;
    private TextView tv1, ans_tv, itv1, itv2, itv3;
    private TextToSpeech tts;
    private ImageButton ib;
    private String s, c;
    private int cnt = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);

        im1 = findViewById(R.id.img1);
        im2 = findViewById(R.id.img2);
        im3 = findViewById(R.id.img3);

        tv1 = findViewById(R.id.matching_tv);
        ans_tv = findViewById(R.id.ans_tv);

        itv1 = findViewById(R.id.im1_tv);
        itv2 = findViewById(R.id.im2_tv);
        itv3 = findViewById(R.id.im3_tv);


        ib = findViewById(R.id.go_next);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.US);
                    tts.setSpeechRate(0.80f);

                }
            }
        });

        ib.setOnClickListener(this);
        im1.setOnClickListener(this);
        im2.setOnClickListener(this);
        im3.setOnClickListener(this);
        tv1.setOnClickListener(this);

        tts.speak(tv1.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (tts == null) {
            tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i != tts.ERROR) {
                        tts.setLanguage(Locale.US);
                        tts.setSpeechRate(0.80f);
                    }
                }
            });

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (tts == null) {
            tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i != tts.ERROR) {
                        tts.setLanguage(Locale.US);
                        tts.setSpeechRate(0.80f);
                    }
                }
            });

        }
    }

    @Override
    public void onPause() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }


    private void shift(int idx) {

        switch (idx) {
            case 2:
                im1.setImageResource(R.drawable.green);
                im2.setImageResource(R.drawable.body_6);
                im3.setImageResource(R.drawable.comb);
                itv1.setText("Leaves");
                itv2.setText("Lips");
                itv3.setText("Comb");
                ans_tv.setText("Comb");
                tv1.setText("Where is the Comb?");
                while (true) {
                    if (!tts.isSpeaking()) {
                        tts.speak(tv1.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                        break;
                    }
                }
                break;
            case 3:
                im1.setImageResource(R.drawable.food);
                im2.setImageResource(R.drawable.bottle);
                im3.setImageResource(R.drawable.toothbrush);
                itv1.setText("food");
                itv2.setText("bottle");
                itv3.setText("toothbrush");
                ans_tv.setText("bottle");
                tv1.setText("Show me the Bottle");
                while (true) {
                    if (!tts.isSpeaking()) {
                        tts.speak(tv1.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                        break;
                    }
                }
                break;
            case 4:
                im1.setImageResource(R.drawable.hand);
                im2.setImageResource(R.drawable.book);
                im3.setImageResource(R.drawable.pencil);
                itv1.setText("Hands");
                itv2.setText("book");
                itv3.setText("pencil");
                ans_tv.setText("pencil");
                tv1.setText("Give me the Pencil");
                while (true) {
                    if (!tts.isSpeaking()) {
                        tts.speak(tv1.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                        break;
                    }
                }
                break;
            case 5:
                im1.setImageResource(R.drawable.blank);
                im2.setImageResource(R.drawable.the_end);
                im3.setImageResource(R.drawable.blank);
                tv1.setText("");
                while (true) {
                    if (!tts.isSpeaking()) {
                        tts.speak("Yayyyy Congratulations", TextToSpeech.QUEUE_FLUSH, null);
                        break;
                    }
                }
                ib.setEnabled(false);
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.img1:
                s = ans_tv.getText().toString();
                c = itv1.getText().toString();
                if (s.equals(c)) {
                    tts.speak("Correct Answer", TextToSpeech.QUEUE_FLUSH, null);
                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                    cnt++;
                    shift(cnt);

                } else {
                    Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_SHORT).show();
                    tts.speak("Try Again", TextToSpeech.QUEUE_FLUSH, null);
                }

                break;

            case R.id.img2:
                s = ans_tv.getText().toString();
                c = itv2.getText().toString();
                if (s.equals(c)) {
                    tts.speak("Correct Answer", TextToSpeech.QUEUE_FLUSH, null);
                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                    cnt++;
                    shift(cnt);
                } else {
                    Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_SHORT).show();
                    tts.speak("Try Again", TextToSpeech.QUEUE_FLUSH, null);
                }
                break;

            case R.id.img3:
                s = ans_tv.getText().toString();
                c = itv3.getText().toString();
                if (s.equals(c)) {
                    tts.speak("Correct Answer", TextToSpeech.QUEUE_FLUSH, null);
                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                    cnt++;
                    shift(cnt);
                } else {
                    Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_SHORT).show();
                    tts.speak("Try Again", TextToSpeech.QUEUE_FLUSH, null);
                }
                break;

            case R.id.matching_tv:
                tts.speak(tv1.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                break;

            case R.id.go_next:
                cnt++;
                shift(cnt);
                break;

            default:
                break;
        }

    }
}
