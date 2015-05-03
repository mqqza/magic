package com.soulreaverq.magic;


import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerAdapter extends ArrayAdapter<NavigationDrawerAdapter.DrawerMenuItem> {

    private final List<DrawerMenuItem> mMenuItems = new ArrayList<>();
    private static final int TYPE_MENU_ITEM = 0;
    private static final int TYPE_DIVIDER = 1;
    private final LayoutInflater mInflater;
    private int mItemSelected;

    public NavigationDrawerAdapter(Context context) {
        super(context, 0);
        this.mInflater = LayoutInflater.from(context);
        setupMenuItems();
    }

    @Override
    public int getCount() {
        return mMenuItems.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public DrawerMenuItem getItem(int position) {
        return mMenuItems.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return mMenuItems.get(position).mIsDivider ? TYPE_DIVIDER : TYPE_MENU_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (getItemViewType(position) == TYPE_MENU_ITEM) {
            if (convertView == null)
                convertView = mInflater.inflate(R.layout.item_listview, parent, false);
            DrawerMenuItem item = getItem(position);
            final ImageView ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);
            TextView tvLabel = (TextView) convertView.findViewById(R.id.tvLabel);
            tvLabel.setText(item.mLabel);
            //ImageLoader.getInstance().displayImage("drawable://" + item.mIconResId, ivIcon);
            ivIcon.setImageResource(item.mIconResId);
            ivIcon.setColorFilter(Color.rgb(128, 128, 128), PorterDuff.Mode.SRC_IN);
            if (position == mItemSelected) {
                ivIcon.setColorFilter(Color.rgb(250, 135, 122), PorterDuff.Mode.SRC_IN);
            }
            ivIcon.setVisibility(item.mIconResId == 0 ? View.GONE : View.VISIBLE);


            return convertView;
        } else {
            return mInflater.inflate(R.layout.item_menu_divider, parent, false);
        }

    }

    public void setPosition(int position) {
        mItemSelected = position;
    }

    private void setupMenuItems() {
        mMenuItems.add(new DrawerMenuItem(R.drawable.ic_profile, mInflater.getContext().getString(R.string.title_profile)));
        mMenuItems.add(new DrawerMenuItem(R.drawable.ic_feed, mInflater.getContext().getString(R.string.title_feed)));
        mMenuItems.add(new DrawerMenuItem(R.drawable.ic_star, mInflater.getContext().getString(R.string.title_stars)));
        mMenuItems.add(DrawerMenuItem.dividerMenuItem());
        mMenuItems.add(new DrawerMenuItem(R.drawable.ic_settings, mInflater.getContext().getString(R.string.title_setting)));
        mMenuItems.add(new DrawerMenuItem(R.drawable.ic_about, mInflater.getContext().getString(R.string.title_about)));
        notifyDataSetChanged();
    }

    public static class DrawerMenuItem {
        public int mIconResId;
        public String mLabel;
        public boolean mIsDivider;

        public DrawerMenuItem(int iconResId, String label) {
            this.mIconResId = iconResId;
            this.mLabel = label;
            this.mIsDivider = false;
        }

        public DrawerMenuItem() {

        }

        public static DrawerMenuItem dividerMenuItem() {
            DrawerMenuItem globalMenuItem = new DrawerMenuItem();
            globalMenuItem.mIsDivider = true;
            return globalMenuItem;
        }
    }
}