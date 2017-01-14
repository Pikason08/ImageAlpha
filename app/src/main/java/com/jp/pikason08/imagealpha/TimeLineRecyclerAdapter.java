package com.jp.pikason08.imagealpha;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.sql.Time;
import java.util.List;

import butterknife.BindView;

/**
 * Created by keigo on 2017/01/14.
 */

public class TimeLineRecyclerAdapter extends RecyclerView.Adapter<TimeLineRecyclerAdapter.ViewHolder> {
    private String[] list;
    private List<TimeLine> dataList;
    private Context context;

    public TimeLineRecyclerAdapter(Context context, List<TimeLine> dataList) {
        super();
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder vh, final int position) {
//        vh.layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
    }

    @Override
    public TimeLineRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.item_time_line, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImage;
        TextView dateText;
        Button favoriteButton;

        public ViewHolder(View v) {
            super(v);
            cardImage = (ImageView)v.findViewById(R.id.card_view_image);
            dateText = (TextView)v.findViewById(R.id.card_view_date);
            favoriteButton = (Button)v.findViewById(R.id.card_view_favorite);
        }
    }
}
