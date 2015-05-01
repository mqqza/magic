package com.soulreaverq.magic;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
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
import java.util.LinkedList;

public class MyFragment2 extends android.support.v4.app.Fragment implements SwipeRefreshLayout.OnRefreshListener {

    RecyclerView mGridView;
    private static final String TAG = "CCC";
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private MyApplication myApp;

    // private static boolean TYPE_OF_COLUMN_SINGLE;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(container.getContext().getResources().getString(R.string.title_feed).toUpperCase());
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        setHasOptionsMenu(true);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorScheme(R.color.colorPrimary);
        //mSwipeRefreshLayout.setColorSchemeColors(R.color.pink, R.color.pink, R.color.pink);


        myApp = (MyApplication) getActivity().getApplicationContext();

        mGridView = (RecyclerView) view.findViewById(R.id.grid_view);
        mGridView.setHasFixedSize(true);

        mGridView.setAdapter(new RecyclerAdapter(R.layout.item_gridview, getActivity(), myApp.getPictureList()));
        mGridView.setItemAnimator(new DefaultItemAnimator());
        mGridView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        mGridView.getAdapter().notifyDataSetChanged();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //inflater.inflate(R.menu.fragment2, menu);
        super.onCreateOptionsMenu(menu, inflater);
        // TYPE_OF_COLUMN_SINGLE = true;
        // MenuItem item = menu.findItem(R.id.column);
        // item.setTitle(R.string.title_column_multi);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       /* switch (item.getItemId()) {
            case R.id.column:
                if (TYPE_OF_COLUMN_SINGLE) {
                    TYPE_OF_COLUMN_SINGLE = false;
                    item.setTitle(R.string.title_column_single);
                    mGridView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                } else {
                    TYPE_OF_COLUMN_SINGLE = true;
                    item.setTitle(R.string.title_column_multi);
                    mGridView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
                }
                return true;
            default:
                break;
        }*/

        return false;
    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);
        new ParseTask().execute();
    }

    private class ParseTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            myApp.addItem(new Picture("drawable://" + R.drawable.example1, 10));
            mGridView.getAdapter().notifyDataSetChanged();
            return null;
        }

        @Override
        protected void onPostExecute(String string) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }
}

