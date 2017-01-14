package com.jp.pikason08.imagealpha;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by keigo on 2017/01/14.
 */

public class MainPagerAdapter extends FragmentPagerAdapter{

    public MainPagerAdapter(FragmentManager manager){
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TimeLineFragment();
            case 1:
                return new LocalImageFragment();
            case 2:
                return new TwitterImageFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "TL";
            case 1:
                return "storage";
            case 2:
                return "twitter";
        }
        return null;
    }
}
