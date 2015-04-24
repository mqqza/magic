package com.soulreaverq.magic;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class MyFragment2 extends android.support.v4.app.Fragment {

    GridView mGridView;
    private static final String TAG = "CCC";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((ActionBarActivity) getActivity()).getSupportActionBar().setSubtitle("Feed");
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        ArrayList<Picture> items = new ArrayList<>();
        items.add(new Picture("drawable://" + R.drawable.q, 5));
        items.add(new Picture("drawable://" + R.drawable.w, 2));
        items.add(new Picture("drawable://" + R.drawable.e, 3));
        items.add(new Picture("drawable://" + R.drawable.r, 4));
        items.add(new Picture("drawable://" + R.drawable.t, 21));
        items.add(new Picture("drawable://" + R.drawable.y, 0));
        items.add(new Picture("drawable://" + R.drawable.qwer, 3));
        items.add(new Picture("drawable://" + R.drawable.u, 0));

        mGridView = (GridView) view.findViewById(R.id.grid_view);
        // Log.v(TAG, items.toString());
        mGridView.setAdapter(new GridViewAdapter2(getActivity(), items));
        return view;
    }
}
