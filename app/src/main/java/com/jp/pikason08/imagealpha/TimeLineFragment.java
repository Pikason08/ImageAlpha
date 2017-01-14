package com.jp.pikason08.imagealpha;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by keigo on 2017/01/14.
 */

public class TimeLineFragment extends Fragment{

    //TODO: ダミー用リスト
    List<TimeLine> dataList = new ArrayList<>();
    public TimeLineFragment(){

    }

    public static void newInstance(){

    }

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

    private void initViews(View view){
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view_time_line);
        LayoutManager layoutManager = new LinearLayoutManager(getContext());
        TimeLineRecyclerAdapter adapter = new TimeLineRecyclerAdapter(getContext(), dataList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void createDummy(){
        TimeLine timeLine = new TimeLine();
        timeLine.setDate("20xx/12/01");
        timeLine.setId(0);
        timeLine.setLocation("https://pixabay.com/ja/%E3%83%95%E3%82%AF%E3%83%AD%E3%82%A6-%E3%83%A1%E3%82%BF%E3%83%A9%E3%82%A4%E3%82%B6-png-%E3%82%A2%E3%83%BC%E3%83%88-%E3%82%AC%E3%83%A9%E3%82%B9-%E5%B7%A5%E5%A0%B4-1791700/");
        dataList.add(timeLine);
    }
}
