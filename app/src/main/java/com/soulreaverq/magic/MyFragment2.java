package com.soulreaverq.magic;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyFragment2 extends android.support.v4.app.Fragment {

    RecyclerView mGridView;
    private static final String TAG = "CCC";
    private static boolean TYPE_OF_COLUMN_SINGLE;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((ActionBarActivity) getActivity()).getSupportActionBar().setSubtitle("Feed");
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        setHasOptionsMenu(true);

        ArrayList<Picture> items = new ArrayList<>();
        items.add(new Picture("drawable://" + R.drawable.example1, 5));
        items.add(new Picture("drawable://" + R.drawable.example2, 2));
        items.add(new Picture("drawable://" + R.drawable.example3, 3));
        items.add(new Picture("drawable://" + R.drawable.example4, 4));
        items.add(new Picture("drawable://" + R.drawable.example5, 21));
        items.add(new Picture("drawable://" + R.drawable.example6, 0));
        items.add(new Picture("drawable://" + R.drawable.example7, 54));
        items.add(new Picture("drawable://" + R.drawable.example8, 3));
        items.add(new Picture("drawable://" + R.drawable.example9, 0));

        mGridView = (RecyclerView) view.findViewById(R.id.grid_view);
        mGridView.setHasFixedSize(true);

        mGridView.setAdapter(new RecyclerAdapter(R.layout.item_gridview, getActivity(), items));
        mGridView.setItemAnimator(new DefaultItemAnimator());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        mGridView.setLayoutManager(gridLayoutManager);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment2, menu);
        super.onCreateOptionsMenu(menu, inflater);
        TYPE_OF_COLUMN_SINGLE = true;
        MenuItem item = menu.findItem(R.id.column);
        item.setTitle(R.string.title_column_multi);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.column:
                if (TYPE_OF_COLUMN_SINGLE) {
                    TYPE_OF_COLUMN_SINGLE = false;
                    item.setTitle(R.string.title_column_single);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
                    mGridView.setLayoutManager(gridLayoutManager);


                    //gridView.setVerticalSpacing(dpAsPixels);
                } else {
                    TYPE_OF_COLUMN_SINGLE = true;
                    item.setTitle(R.string.title_column_multi);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
                    mGridView.setLayoutManager(gridLayoutManager);
                }
                return true;
            default:
                break;
        }

        return false;
    }
}

