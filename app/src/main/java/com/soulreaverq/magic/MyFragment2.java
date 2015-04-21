package com.soulreaverq.magic;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import java.util.ArrayList;

public class MyFragment2 extends android.support.v4.app.Fragment {

    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((ActionBarActivity)getActivity()).getSupportActionBar().setSubtitle("Feed");
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        ArrayList<String> items = new ArrayList<>();
        items.add("q");
        items.add("w");
        items.add("e");
        items.add("r");
        items.add("t");
        items.add("y");
        items.add("u");
        items.add("qwer");
        items.add("q");
        items.add("w");
        items.add("e");
        items.add("r");
        items.add("t");
        items.add("y");
        items.add("u");
        items.add("qwer");
        items.add("q");
        items.add("w");
        items.add("e");
        items.add("r");
        items.add("t");
        items.add("y");
        items.add("u");
        gridView = (GridView) view.findViewById(R.id.grid_view);
        gridView.setVerticalScrollBarEnabled(false);
        gridView.setAdapter(new GridViewAdapter(getActivity(), items));
        return view;
    }
}
