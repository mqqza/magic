package com.soulreaverq.magic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class MyFragment1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((ActionBarActivity) getActivity()).getSupportActionBar().setSubtitle("Profile");
        return inflater.inflate(R.layout.fragment_one, container, false);

    }
}
