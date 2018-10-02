package com.example.muhamin.speechbee;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText uname, pass;
    Button sign,log;
    private FirebaseAuth mAuth;
    private ProgressDialog pd;
    private Dialog d;
    private String email,passwrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uname=findViewById(R.id.emailinput);
        pass=findViewById(R.id.passwordinput);
        sign=findViewById(R.id.btSignUp);
        log=findViewById(R.id.btLog);

        mAuth=FirebaseAuth.getInstance();
        pd=new ProgressDialog(this);

        log.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                login();
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

    }

    void login(){
        email=uname.getText().toString().trim();
        passwrd=pass.getText().toString().trim();
        if(passwrd.length()>=6) {
            pd.setMessage("Logging in");
            pd.show();
            mAuth.signInWithEmailAndPassword(email, passwrd)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(getApplicationContext(), "Logging in", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, NavigationHome.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "User Doesn't exist", Toast.LENGTH_SHORT).show();
                            }
                            pd.dismiss();
                            // ...
                        }
                    });
        }
        else
        {
            AlertDialog.Builder b;
            b = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
            b.setTitle("Error")
                    .setMessage("Password Length must be 6")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }
    void signup(){
        email=uname.getText().toString().trim();
        passwrd=pass.getText().toString().trim();
        if(!email.isEmpty() && passwrd.length()>=6)
        {
            pd.setMessage("Signing up");
            pd.show();
            mAuth.createUserWithEmailAndPassword(email, passwrd)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(getApplicationContext(),"Signed up",Toast.LENGTH_SHORT).show();
                            } else {

                                Toast.makeText(LoginActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }
                            pd.dismiss();;

                            // ...
                        }
                    });
        }
    }


}
