package com.jp.pikason08.imagealpha;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by keigo on 2017/01/14.
 */

public class TimeLineRecyclerAdapter extends RecyclerView.Adapter<TimeLineRecyclerAdapter.ViewHolder> {

    private List<TimeLine> dataList;
    private Context context;
    private OnClickCardListener listener;
    private onClickCardButtonListener buttonListener;

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
        if (dataList.get(position).getImageType() == 0) {
            Picasso.with(context)
                    .load(dataList.get(position).getUrl())
                    .placeholder(R.drawable.ic_account_circle_white_24dp)
                    .into(vh.cardImage);
        } else {
            vh.cardImage.setImageBitmap(dataList.get(position).getBitmap());
        }
        vh.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v, position);
            }
        });
        if (dataList.get(position).isFavoriteState()) {
            vh.favoImage.setImageResource(R.drawable.ic_favorite_red_700_24dp);
        } else {
            vh.favoImage.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        }
        vh.favoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonListener.onClick(v, position, dataList.get(position).isFavoriteState());
            }
        });
    }

    public void setCardClick(OnClickCardListener listener) {
        this.listener = listener;
    }

    public void setCardButtonClick(onClickCardButtonListener buttonListener) {
        this.buttonListener = buttonListener;
    }

    public interface onClickCardButtonListener {
        void onClick(View view, int position, boolean state);
    }

    public interface OnClickCardListener {
        void onClick(View view, int position);
    }

    @Override
    public TimeLineRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.item_time_line, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView cardImage;
        TextView dateText;
        ImageView favoImage;

        public ViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.card_view);
            cardImage = (ImageView) v.findViewById(R.id.card_view_image);
            dateText = (TextView) v.findViewById(R.id.card_view_date);
            favoImage = (ImageView) v.findViewById(R.id.card_view_favorite);
        }
    }
}
