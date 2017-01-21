package com.jp.pikason08.imagealpha;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    protected static final int REQUEST_CAPTURE_IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        FloatingActionButton favButton = (FloatingActionButton)findViewById(R.id.float_button);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        FragmentManager manager = getSupportFragmentManager();
        MainPagerAdapter adapter = new MainPagerAdapter(manager);
        viewPager.setAdapter(adapter);
        tabLayout.setTabTextColors(getResources().getColor(R.color.unselect_tab), getResources().getColor(R.color.white));
        tabLayout.setupWithViewPager(viewPager);
        favButton.setOnClickListener(clickFavButton);
    }

    View.OnClickListener clickFavButton = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, REQUEST_CAPTURE_IMAGE);
        }
    };
}
