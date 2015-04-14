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

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerAdapter extends ArrayAdapter<NavigationDrawerAdapter.DrawerMenuItem> {

    private final List<DrawerMenuItem> menuItems = new ArrayList<>();
    private static final int TYPE_MENU_ITEM = 0;
    private static final int TYPE_DIVIDER = 1;
    private final LayoutInflater inflater;
    private int mItemSelected;

    public NavigationDrawerAdapter(Context context) {
        super(context, 0);
        this.inflater = LayoutInflater.from(context);
        setupMenuItems();
    }


    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public DrawerMenuItem getItem(int position) {
        return menuItems.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return menuItems.get(position).isDivider ? TYPE_DIVIDER : TYPE_MENU_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (getItemViewType(position) == TYPE_MENU_ITEM) {
            if (convertView == null)
                convertView = inflater.inflate(R.layout.item_listview, parent, false);
            DrawerMenuItem item = getItem(position);
            final ImageView ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);
            TextView tvLabel = (TextView) convertView.findViewById(R.id.tvLabel);
            tvLabel.setText(item.label);
            ivIcon.setImageResource(item.iconResId);
            ivIcon.setColorFilter(Color.rgb(128,128,128), PorterDuff.Mode.SRC_IN);
            if (position == mItemSelected ) {
                ivIcon.setColorFilter(Color.rgb(250, 135, 122), PorterDuff.Mode.SRC_IN);
            }
            ivIcon.setVisibility(item.iconResId == 0 ? View.GONE : View.VISIBLE);

            return convertView;
        } else {
            return inflater.inflate(R.layout.item_menu_divider, parent, false);
        }

    }

    public void setPosition(int position){
        mItemSelected = position;
    }

    private void setupMenuItems() {
        menuItems.add(new DrawerMenuItem(R.drawable.ic_profile, inflater.getContext().getString(R.string.title_profile)));
        menuItems.add(new DrawerMenuItem(R.drawable.ic_feed, inflater.getContext().getString(R.string.title_feed)));
        menuItems.add(new DrawerMenuItem(R.drawable.ic_star, inflater.getContext().getString(R.string.title_stars)));
        menuItems.add(DrawerMenuItem.dividerMenuItem());
        menuItems.add(new DrawerMenuItem(R.drawable.ic_settings, inflater.getContext().getString(R.string.title_setting)));
        menuItems.add(new DrawerMenuItem(R.drawable.ic_about, inflater.getContext().getString(R.string.title_about)));
        notifyDataSetChanged();
    }

    public static class DrawerMenuItem {
        public int iconResId;
        public String label;
        public boolean isDivider;

        public DrawerMenuItem(int iconResId, String label) {
            this.iconResId = iconResId;
            this.label = label;
            this.isDivider = false;
        }

        public DrawerMenuItem() {

        }

        public static DrawerMenuItem dividerMenuItem() {
            DrawerMenuItem globalMenuItem = new DrawerMenuItem();
            globalMenuItem.isDivider = true;
            return globalMenuItem;
        }
    }
}