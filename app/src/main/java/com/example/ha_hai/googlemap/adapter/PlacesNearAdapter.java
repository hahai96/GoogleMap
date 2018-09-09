package com.example.ha_hai.googlemap.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ha_hai.googlemap.ui.detail.DetailActivity;
import com.example.ha_hai.googlemap.R;
import com.example.ha_hai.googlemap.Retrofit.places.FoursquareResults;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ha_hai on 9/9/2018.
 */
public class PlacesNearAdapter extends RecyclerView.Adapter<PlacesNearAdapter.PlacesNearViewHolder> {
    private final Context context;
    private List<FoursquareResults> items;

    public PlacesNearAdapter(List<FoursquareResults> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public PlacesNearViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new PlacesNearViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PlacesNearViewHolder holder, int position) {
        FoursquareResults item = items.get(position);

        holder.txtName.setText(item.venue.name);
        holder.txtAddress.setText(item.venue.location.address);
        holder.txtDistance.setText(item.venue.location.distance + "m");
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public class PlacesNearViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.txtAddress)
        TextView txtAddress;
        @BindView(R.id.txtDistance)
        TextView txtDistance;

        public PlacesNearViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("id", items.get(getAdapterPosition()).venue.id);
                    context.startActivity(intent);
                }
            });
        }
    }
}