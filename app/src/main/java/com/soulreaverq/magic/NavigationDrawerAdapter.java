package com.soulreaverq.magic;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerAdapter extends ArrayAdapter<NavigationDrawerAdapter.DrawerListMenuItem> {

    private final List<DrawerListMenuItem> menuItems = new ArrayList<>();
    private static final int TYPE_MENU_ITEM = 0;
    private static final int TYPE_DIVIDER = 1;
    private final LayoutInflater inflater;

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
    public DrawerListMenuItem getItem(int position) {
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
            DrawerListMenuItem item = getItem(position);
            ImageView ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);
            TextView tvLabel = (TextView) convertView.findViewById(R.id.tvLabel);
            tvLabel.setText(item.label);
            ivIcon.setImageResource(item.iconResId);
            ivIcon.setVisibility(item.iconResId == 0 ? View.GONE : View.VISIBLE);

            return convertView;
        } else {
            return inflater.inflate(R.layout.item_menu_divider, parent, false);
        }

    }

    private void setupMenuItems() {

        menuItems.add(new DrawerListMenuItem(R.drawable.ic_drawer, inflater.getContext().getString(R.string.title_profile)));
        menuItems.add(new DrawerListMenuItem(R.drawable.ic_drawer, inflater.getContext().getString(R.string.title_feed)));
        menuItems.add(new DrawerListMenuItem(R.drawable.ic_drawer, inflater.getContext().getString(R.string.title_fav)));
        menuItems.add(DrawerListMenuItem.dividerMenuItem());
        menuItems.add(new DrawerListMenuItem(0, inflater.getContext().getString(R.string.title_setting)));
        menuItems.add(new DrawerListMenuItem(0, inflater.getContext().getString(R.string.title_about)));
        notifyDataSetChanged();
    }

    public static class DrawerListMenuItem {
        public int iconResId;
        public String label;
        public boolean isDivider;

        public DrawerListMenuItem(int iconResId, String label) {
            this.iconResId = iconResId;
            this.label = label;
            this.isDivider = false;
        }

        public DrawerListMenuItem() {

        }

        public static DrawerListMenuItem dividerMenuItem() {
            DrawerListMenuItem globalMenuItem = new DrawerListMenuItem();
            globalMenuItem.isDivider = true;
            return globalMenuItem;
        }
    }
}