package com.example.muhamin.speechbee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class chatActivity extends AppCompatActivity {

    private Intent intent;
    private String roll, name, sender, sroll;
    private ListView chatArea;
    private EditText lala;
    private Button send;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference msgRef;
    DatabaseReference msgRefsender;
    List<Message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatArea = findViewById(R.id.chatArea);
        lala = findViewById(R.id.msgbox);
        send = findViewById(R.id.send);


        intent = this.getIntent();
        roll = intent.getStringExtra("receiveremail");
        name = intent.getStringExtra("receivername");
        sender = intent.getStringExtra("sendername");
        sroll = intent.getStringExtra("senderemail");
        messages = new ArrayList<>();

        firebaseDatabase = FirebaseDatabase.getInstance();
        if (roll.compareTo(sroll) == -1) {
            msgRef = firebaseDatabase.getReference("user_chat").child(sroll + "_" + roll);
        } else {
            msgRef = firebaseDatabase.getReference("user_chat").child(roll + "_" + sroll);
        }


        msgRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (messages.size() != 0)
                    messages.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Message msg = dataSnapshot1.getValue(Message.class);
                    messages.add(msg);
                }
                chatAdapter chatAdapter = new chatAdapter(chatActivity.this, messages);
                chatArea.setAdapter(chatAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(chatActivity.this, "network error", Toast.LENGTH_LONG).show();
            }
        });


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lala.getText().toString().matches("")) {
                    Toast.makeText(chatActivity.this, "-_- enter a message", Toast.LENGTH_LONG).show();
                    return;
                }
                String pk = msgRef.push().getKey();
                Message msg = new Message(sender, String.valueOf(System.currentTimeMillis()), lala.getText().toString());
                msgRef.child(pk).setValue(msg);
                Toast.makeText(chatActivity.this, "Ashce :/", Toast.LENGTH_LONG).show();
            }
        });
    }
}
