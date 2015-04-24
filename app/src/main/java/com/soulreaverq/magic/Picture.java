package com.soulreaverq.magic;

public class Picture {
    String mImage;
    int mLikes;

    Picture(String image, int likes) {
        mImage = image;
        mLikes = likes;
    }

    public String getImage() {
        return mImage;
    }

    public int getLikes() {
        return mLikes;
    }
}
