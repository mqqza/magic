package com.soulreaverq.magic;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private ArrayList<Picture> mItems;

    public GridViewAdapter(Context context, ArrayList<Picture> items) {
        this.mInflater = LayoutInflater.from(context);
        this.mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_gridview, parent, false);
            viewHolder = new GridViewHolder();
            viewHolder.mImageView = (SquareImageView) convertView.findViewById(R.id.imageView);
            viewHolder.mLikesView = (TextView) convertView.findViewById(R.id.likeView);

            convertView.setTag(viewHolder);

        } else viewHolder = (GridViewHolder) convertView.getTag();

        ImageLoader.getInstance().displayImage(mItems.get(position).getImage(), viewHolder.mImageView);
        viewHolder.mLikesView.setText(Integer.toString(mItems.get(position).getLikes()));
        return convertView;
    }

    private static class GridViewHolder {

        public SquareImageView mImageView;
        public TextView mLikesView;

    }
}

