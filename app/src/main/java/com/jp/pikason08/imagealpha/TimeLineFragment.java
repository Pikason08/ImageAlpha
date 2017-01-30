package com.jp.pikason08.imagealpha;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by keigo on 2017/01/14.
 */

public class TimeLineFragment extends Fragment {

    List<TimeLine> dataList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createDummy();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time_line, null);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_time_line);
        LayoutManager layoutManager = new LinearLayoutManager(getContext());
        TimeLineRecyclerAdapter adapter = new TimeLineRecyclerAdapter(getContext(), dataList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setCardClick(new TimeLineRecyclerAdapter.OnClickCardListener() {
            @Override
            public void onClick(View view, int position) {
                //TODO: add action click layout
            }
        });
        adapter.setCardButtonClick(new TimeLineRecyclerAdapter.onClickCardButtonListener() {
            @Override
            public void onClick(View view, int position, boolean state) {
                //TODO: add action click button
                ImageView favoButton = (ImageView) view.findViewById(R.id.card_view_favorite);
                if (state) {
                    favoButton.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    dataList.get(position).setFavoriteState(false);
                } else {
                    favoButton.setImageResource(R.drawable.ic_favorite_red_700_24dp);
                    dataList.get(position).setFavoriteState(true);
                }
                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.touch);
                view.startAnimation(animation);
            }
        });
    }

    private void createDummy() {
        for (int i = 0; i < 10; i++) {
            TimeLine timeLine = new TimeLine();
            timeLine.setImageType(0);
            timeLine.setDate("20xx/12/01");
            timeLine.setId(0);
            timeLine.setUrl("https://cdn.pixabay.com/photo/2017/01/14/10/56/taste-1979268_1280.jpg");
            dataList.add(timeLine);
        }
    }
}
