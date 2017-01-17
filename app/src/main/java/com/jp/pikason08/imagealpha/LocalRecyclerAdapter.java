package com.jp.pikason08.imagealpha;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by keigo on 2017/01/15.
 */

public class LocalRecyclerAdapter extends RecyclerView.Adapter<LocalRecyclerAdapter.ViewHolder> {
    private List<LocalData> dataList;
    private Context context;

    public LocalRecyclerAdapter(Context context, List<LocalData> dataList) {
        super();
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onBindViewHolder(LocalRecyclerAdapter.ViewHolder vh, final int position) {
        //TODO: setStorageImages
//        vh.localImage.setImageBitmap(dataList.get(position).getLocalImage());
        Picasso.with(context)
                .load("https://images.pexels.com/photos/203946/pexels-photo-203946.jpeg?w=940&h=650&auto=compress&cs=tinysrgb")
                .placeholder(R.mipmap.ic_launcher)
                .into(vh.localImage);
        vh.localImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: click action
            }
        });
    }

    public interface setItemClick{
        void onItemClick();
    }

    @Override
    public LocalRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.item_recycler_view_local, parent, false);
        return new ViewHolder(v);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView localImage;

        public ViewHolder(View v) {
            super(v);
            localImage = (ImageView)v.findViewById(R.id.recycler_view_local_image);
        }
    }
}
