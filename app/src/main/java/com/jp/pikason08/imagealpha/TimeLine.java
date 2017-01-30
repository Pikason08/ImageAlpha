package com.jp.pikason08.imagealpha;

import android.graphics.Bitmap;

/**
 * Created by keigo on 2017/01/14.
 */

public class TimeLine {

    //url: 0, local: 1
    private int imageType;
    private String url;

    public boolean isFavoriteState() {
        return favoriteState;
    }

    public void setFavoriteState(boolean favoriteState) {
        this.favoriteState = favoriteState;
    }

    private Bitmap bitmap;
    private boolean favoriteState;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    private int id;
    private String date;

    public int getImageType() {
        return imageType;
    }

    public void setImageType(int imageType) {
        this.imageType = imageType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
