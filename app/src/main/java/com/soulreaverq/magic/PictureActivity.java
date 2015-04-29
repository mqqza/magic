package com.soulreaverq.magic;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;


public class PictureActivity extends ActionBarActivity {

    private static final String TAG = "CCC";
    private String mTitle;
    private String mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setSubtitle("Picture");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTitle = getIntent().getStringExtra("title");
        mImage = getIntent().getStringExtra("image");

        TextView textView = (TextView) findViewById(R.id.title);
        SquareImageView imageView = (SquareImageView) findViewById(R.id.image);

        textView.setText("LIKES: " + mTitle);
        ImageLoader.getInstance().displayImage(mImage, imageView);
    }
}
