package com.jp.pikason08.imagealpha;

import android.graphics.Bitmap;

/**
 * Created by keigo on 2017/01/16.
 */

public class LocalData {

    private Bitmap localImage;
    private int id;
    private String date;

    public Bitmap getLocalImage() {
        return localImage;
    }

    public void setLocalImage(Bitmap localImage) {
        this.localImage = localImage;
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
