package com.soulreaverq.magic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Picture> items;
    private int itemLayout;
    private Context context;

    public RecyclerAdapter(int itemLayout, Context context, List<Picture> items) {
        this.itemLayout = itemLayout;
        this.items = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        final Picture item = items.get(position);
        viewHolder.mLikesView.setText(Integer.toString(item.getLikes()));
        ImageLoader.getInstance().displayImage(item.getImage(), viewHolder.mImageView);
        viewHolder.itemView.setTag(item);
        viewHolder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PictureActivity.class);
                intent.putExtra("title", Integer.toString(item.getLikes()));
                intent.putExtra("image", item.getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public SquareImageView mImageView;
        public TextView mLikesView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (SquareImageView) itemView.findViewById(R.id.imageView);
            mLikesView = (TextView) itemView.findViewById(R.id.likeView);
        }
    }


}
