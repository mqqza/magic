package com.soulreaverq.magic;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class MyFragment2 extends android.support.v4.app.Fragment {

    GridView mGridView;
    private static final String TAG = "CCC";
    private static boolean TYPE_OF_COLUMN = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((ActionBarActivity) getActivity()).getSupportActionBar().setSubtitle("Feed");
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        setHasOptionsMenu(true);

        ArrayList<Picture> items = new ArrayList<>();
        items.add(new Picture("drawable://" + R.drawable.q, 5));
        items.add(new Picture("drawable://" + R.drawable.w, 2));
        items.add(new Picture("drawable://" + R.drawable.e, 3));
        items.add(new Picture("drawable://" + R.drawable.r, 4));
        items.add(new Picture("drawable://" + R.drawable.t, 21));
        items.add(new Picture("drawable://" + R.drawable.y, 0));
        items.add(new Picture("drawable://" + R.drawable.qwer, 3));
        items.add(new Picture("drawable://" + R.drawable.u, 0));

        items.add(new Picture("drawable://" + R.drawable.ewq, 54));

        mGridView = (GridView) view.findViewById(R.id.grid_view);
        // Log.v(TAG, items.toString());
        mGridView.setAdapter(new GridViewAdapter(getActivity(), items));
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment2, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.column:
                float scale = getResources().getDisplayMetrics().density;
                int dpAsPixels = (int) (4*scale + 0.5f);
                GridView gridView = (GridView) getActivity().findViewById(R.id.grid_view);
                if (TYPE_OF_COLUMN) {
                    TYPE_OF_COLUMN = false;
                    item.setTitle(R.string.title_column_multi);
                    gridView.setNumColumns(2);
                    gridView.setPadding(dpAsPixels,dpAsPixels,dpAsPixels,dpAsPixels);
                } else {
                    TYPE_OF_COLUMN = true;
                    item.setTitle(R.string.title_column_single);
                    gridView.setNumColumns(1);
                    gridView.setPadding(0,dpAsPixels,0,dpAsPixels);
                }
                return true;
            default:
                break;
        }

        return false;
    }
}
