package com.example.muhamin.speechbee;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }

    Activity context;

    private Button b;
    private ImageView im;
    private TextView tv;
    private EditText et;
    private DatabaseReference ref;
    //private

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = this.getActivity();
        View thisFragment = inflater.inflate(R.layout.fragment_profile, container, false);


        et = thisFragment.findViewById(R.id.et);
        tv = thisFragment.findViewById(R.id.tv);
        im = thisFragment.findViewById(R.id.image);
        b = thisFragment.findViewById(R.id.button);

        ref = FirebaseDatabase.getInstance().getReference();

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

}
