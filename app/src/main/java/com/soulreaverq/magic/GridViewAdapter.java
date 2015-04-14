package com.soulreaverq.magic;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    int[] imageId;
    private final LayoutInflater inflater;

    public GridViewAdapter(Context context, int[] prgmImages) {
        imageId = prgmImages;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.item_gridview, null);
        holder.img = (ImageView) rowView.findViewById(R.id.imageView1);

        holder.img.setImageResource(imageId[position]);

        return rowView;
    }

    public class Holder {
        ImageView img;
    }
}