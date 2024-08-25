package com.example.krishportfolio;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.hdodenhof.circleimageview.CircleImageView;

public class mainFragment extends Fragment {

    CircleImageView myprofile;
    public mainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        myprofile = view.findViewById(R.id.myprofile);

        view.findViewById(R.id.hobbies).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hobbies sheet = new Hobbies();
                sheet.show(getActivity().getSupportFragmentManager(), sheet.getTag());
            }
        });


        myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.big_profile_layout);
                dialog.setCancelable(true);
                dialog.show();
            }
        });


        return view;
    }
}