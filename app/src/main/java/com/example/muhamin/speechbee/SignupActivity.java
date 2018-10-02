package com.example.muhamin.speechbee;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignupActivity extends AppCompatActivity {

    EditText Name, Pass, Email, Age, Phn;
    Button Signupbt;
    private FirebaseAuth mAuth;
    private ProgressDialog pd;
    private Dialog d;
    private StudentInfo student;
    ProgressDialog progressBar;
   private DatabaseReference refDatabase;
    String uname, upass, uage, uphn, uemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Name = findViewById(R.id.name);
        Pass = findViewById(R.id.pass);
        Age = findViewById(R.id.age);
        Phn = findViewById(R.id.contact);
        Email= findViewById(R.id.email);
        Signupbt = findViewById(R.id.btSignUp);

        mAuth = FirebaseAuth.getInstance();

        refDatabase = FirebaseDatabase.getInstance().getReference();
        progressBar = new ProgressDialog(this);

        Signupbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAllInputData();
                createStudent();
                createAccountAndSaveInfo();
            }
        });

    }
    void getAllInputData() {
        uname = Name.getText().toString();
        uage = Age.getText().toString();
        uphn = Phn.getText().toString();
        uemail = Email.getText().toString();
        upass = Pass.getText().toString();
    }
    void createStudent() {
        student = new StudentInfo(uname, upass, uage, uphn, uemail);
    }
    void createAccountAndSaveInfo(){
        progressBar.setMessage("Signing in..");

        Log.w("mymsg","came this far never");
        progressBar.show();
        mAuth.createUserWithEmailAndPassword(uemail, upass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = mAuth.getCurrentUser();
                            refDatabase  = FirebaseDatabase.getInstance().getReference();
                            refDatabase.child(user.getUid()).setValue(student);
                            progressBar.dismiss();

                            Intent intent = new Intent(SignupActivity.this, TherapyLevelActivity.class);
                            startActivity(intent);

                        } else
                        {

                            Toast.makeText(SignupActivity.this, "Cannot sign in",
                                    Toast.LENGTH_SHORT).show();
                        }
                                            }                 });     }



}
