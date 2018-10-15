package com.example.muhamin.speechbee;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class SignupActivity extends AppCompatActivity {

    private EditText Name, Pass, Email, Age, Phn, Conf;
    private Button Signupbt;
    private FirebaseAuth mAuth;
    private ProgressDialog pd;
    private Dialog d;
    private StudentInfo student;
    private ProgressDialog progressBar;
    private DatabaseReference refDatabase;
    private String uname, upass, uage, uphn, uemail, upass2;
    private ImageView profile_image;
    private DatePickerDialog date;
    private SimpleDateFormat dateFormatter;
    private Uri filePath;
    private final int PICK_IMAGE_REQUEST = 71;
    FirebaseStorage storage;
    StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference("images");

        profile_image = findViewById(R.id.imageView);
        Name = findViewById(R.id.name);
        Pass = findViewById(R.id.pass);
        Age = findViewById(R.id.age);
        Phn = findViewById(R.id.contact);
        Email = findViewById(R.id.email);
        Signupbt = findViewById(R.id.btSignUp);
        Conf = findViewById(R.id.pass2);
        dateFormatter = new SimpleDateFormat("dd / MM / yyyy", Locale.US);
        mAuth = FirebaseAuth.getInstance();

        refDatabase = FirebaseDatabase.getInstance().getReference();
        progressBar = new ProgressDialog(this);

        Age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int mon = c.get(Calendar.MONTH);
                int yea = c.get(Calendar.YEAR);
                date = new DatePickerDialog(SignupActivity.this, android.R.style.Theme_Holo_Light_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                        String st = getAge(y, m + 1);
                        Age.setText(st + "(" + d + " / " + (m + 1) + " / " + y + ")");
                    }
                }, yea, mon, day);
                date.getDatePicker().setSpinnersShown(true);
                date.show();
            }
        });
        Log.d("Muhaimin", "age peyechi");


        Signupbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAllInputData();
                createStudent();
                createAccountAndSaveInfo();
            }
        });
        Log.d("Muhaimin", "button called");


        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();
            }
        });
        Log.d("Muhaimin", "image called");
    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                profile_image.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void uploadImage() {

        if (filePath != null) {
            progressBar.setTitle("Uploading...");
            progressBar.show();

            StorageReference ref = FirebaseStorage.getInstance().getReference("user").child("images/" + uemail.replace('@', '_').replace('.', '_'));
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressBar.dismiss();
                            Toast.makeText(SignupActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressBar.dismiss();
                            Toast.makeText(SignupActivity.this, "Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot
                                    .getTotalByteCount());
                            progressBar.setMessage("Uploaded " + (int) progress + "%");
                        }
                    });
        }
    }

    String getAge(int y, int m) {
        Date daate = Calendar.getInstance().getTime();

        int yr = daate.getYear() + 1900;
        int mo = daate.getMonth() + 1;

        int yrs = yr - y;
        if (yr < y) {
            yrs--;
        }
        int mons = mo - m;
        if (mo < m) {
            mons = 12 + mons;
        }
        String st = yrs + " Years " + mons + " Months ";
        return st;
    }

    void getAllInputData() {
        uname = Name.getText().toString();
        uage = Age.getText().toString();
        uphn = Phn.getText().toString();
        uemail = Email.getText().toString().trim();
        upass = Pass.getText().toString().trim();
        upass2 = Conf.getText().toString().trim();
    }

    void createStudent() {
        student = new StudentInfo(uname, uage, uphn, uemail);
    }

    boolean check() {
        if (uname.matches("")) {
            Name.setError("Name is Required");
            Name.requestFocus();
            return false;
        }
        if (uage.matches("")) {
            Age.setError("Date of Birth is Required");
            Age.requestFocus();
            return false;
        }
        if (uemail.matches("")) {
            Email.setError("Enter Email Address");
            Email.requestFocus();
            return false;
        }
        if (upass.length() < 6) {
            Pass.setError("Enter 6 Letter Password");
            Pass.requestFocus();
            return false;
        }
        if (!upass2.matches(upass)) {
            Conf.setError("Password didn't Match");
            Conf.requestFocus();
            return false;
        }
        return true;
    }


    void createAccountAndSaveInfo() {
        if (check()) {
            progressBar.setMessage("Signing up...");
            progressBar.show();
            mAuth.createUserWithEmailAndPassword(uemail, upass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                uploadImage();
                                FirebaseUser user = mAuth.getCurrentUser();
                                //Log.d("Muhaimin", "user found");
                                refDatabase = FirebaseDatabase.getInstance().getReference("User");
                                //Log.d("Muhaimin", "database instance found");
                                refDatabase.child(user.getUid()).setValue(student);
                                //Log.d("Muhaimin", "child created");

                                progressBar.dismiss();
                                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                                startActivity(intent);

                            } else {
                                progressBar.dismiss();
                                Toast.makeText(SignupActivity.this, "Signup Failed",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}
