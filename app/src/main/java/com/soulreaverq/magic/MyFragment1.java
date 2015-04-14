package com.soulreaverq.magic;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;


public class MyFragment1 extends Fragment {

    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        int[] images = {
                R.drawable.untitled, R.drawable.untitled, R.drawable.untitled,
                R.drawable.untitled, R.drawable.untitled, R.drawable.untitled,
                R.drawable.untitled, R.drawable.untitled, R.drawable.untitled,
                R.drawable.untitled, R.drawable.untitled, R.drawable.untitled,
                R.drawable.untitled, R.drawable.untitled, R.drawable.untitled,
        };
        // gridArray.add(new Item(image));
        gridView = (GridView) view.findViewById(R.id.grid_view);
        gridView.setAdapter(new GridViewAdapter(getActivity(), images));
        return view;
    }
}
