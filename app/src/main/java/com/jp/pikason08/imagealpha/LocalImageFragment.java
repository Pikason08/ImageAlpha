package com.jp.pikason08.imagealpha;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by keigo on 2017/01/14.
 */

public class LocalImageFragment extends Fragment
        implements SwipeRefreshLayout.OnRefreshListener {


    private List<LocalData> localData = new ArrayList<>();

    protected final static int COLUMN_NUM = 3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createDummy();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local_image, null);
        ButterKnife.bind(this, view);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh_layout);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view_local);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.refresh_color1),
                getResources().getColor(R.color.refresh_color2),
                getResources().getColor(R.color.refresh_color3),
                getResources().getColor(R.color.refresh_color4));
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_local);
        LocalRecyclerAdapter adapter = new LocalRecyclerAdapter(getContext(), localData);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity(), COLUMN_NUM);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setItemClick(new LocalRecyclerAdapter.OnClickItemListener() {
            @Override
            public void onClick(View view, int position) {
            }
        });
    }

    private void createDummy() {
        for (int i = 0; i < 15; i++) {
            LocalData data = new LocalData();
            data.setId(i);
            data.setDate("201" + i + "/xx/yy");
            data.setLocalImage(null);
            localData.add(data);
        }
    }

    @Override
    public void onRefresh() {
        //TODO: add swipe action
    }
}
