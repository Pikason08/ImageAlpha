package com.jp.pikason08.imagealpha;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by keigo on 2017/01/20.
 */

public class FavoriteImage extends RealmObject{

    private String url;
    private String name;

    @Ignore
    private int id;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
