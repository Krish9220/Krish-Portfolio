package com.example.krishportfolio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class contactFragment extends Fragment {

    private EditText email,message;
    private Button send;
    CircleImageView leetCode,codingNinjas,gitHub,linkedIn;
    public contactFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_contact, container, false);

        email = view.findViewById(R.id.email);
        message = view.findViewById(R.id.message);
        send = view.findViewById(R.id.send);

        leetCode=view.findViewById(R.id.leetcode);
        codingNinjas = view.findViewById(R.id.codingninjas);
        gitHub = view.findViewById(R.id.github);
        linkedIn = view.findViewById(R.id.linkedin);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidatoin();
            }
        });

        leetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://leetcode.com/u/_krish_/");
            }
        });
        codingNinjas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.naukri.com/code360/profile/70453103-9c9f-4d27-9718-63e031695b8c");
            }
        });
        gitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://github.com/Krish9220");

            }
        });
        linkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.linkedin.com/in/krish-singh-9ba190297/");

            }
        });

        return  view;
    }

    private void checkValidatoin()
    {
        String user = email.getText().toString().trim();
        String msg = message.getText().toString().trim();

        if(TextUtils.isEmpty(user))//user.isEmpty() both are same but the TextUtils.EditText(user) is more good it handles null value exceptions.
        {
            email.setError("Email is Requried");//show the error to right side of edit text
            email.requestFocus();//the cursor will goto that edit text.
            return;
        }
        if(user.length()<11)
        {
            email.setError("Please Enter Currect Email");
            email.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(msg))
        {
            message.setError("Message is Empty");
            message.requestFocus();
            return;
        }

        if(msg.length()<10)
        {
            message.setError("Minimum 10 character require");
            message.requestFocus();
            return;
        }

        Toast.makeText(getActivity(), "Message Successfully Sent !!", Toast.LENGTH_LONG).show();

    }


    //handing the icon click
    private void gotoUrl(String url)
    {
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}