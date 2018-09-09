package com.example.ha_hai.googlemap.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.ha_hai.googlemap.R;
import com.example.ha_hai.googlemap.Retrofit.image.Item;
import com.example.ha_hai.googlemap.Utils.ParseUrlImageUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ha_hai on 9/9/2018.
 */
public class ImageRecyclerAdapter extends RecyclerView.Adapter<ImageRecyclerAdapter.MyHolder> {
    private final Context context;
    private List<Item> items;

    public ImageRecyclerAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent,
                                       int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_row_item, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Item item = items.get(position);
        String image = ParseUrlImageUtils.parseUrlImage(item.getPrefix(), item.getSuffix());
        Glide.with(context).load(image).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.thumbnail)
        ImageView thumbnail;

        public MyHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}