package com.soulreaverq.magic;

import android.content.ClipData;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;


public class MyFragment1 extends Fragment {

    GridView gridView;
    ArrayList<ClipData.Item> gridArray = new ArrayList<ClipData.Item>();
    GridViewAdapter gridAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        Bitmap image = BitmapFactory.decodeResource(this.getResources(),R.drawable.example_image);
        gridArray.add(new Item(image));

        return view;
    }
}
