package com.example.ha_hai.googlemap.ui.detail;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import com.example.ha_hai.googlemap.R;
import com.example.ha_hai.googlemap.Retrofit.image.*;
import com.example.ha_hai.googlemap.Utils.GridSpacingItemDecoration;
import com.example.ha_hai.googlemap.adapter.ImageRecyclerAdapter;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailActivity extends AppCompatActivity implements DetailMvpView {

    DetailPresenter detailPresenter;

    @BindView(R.id.recycler_view_image)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        detailPresenter = new DetailPresenter();
        detailPresenter.getImages();
    }

    @Override
    public void setAdapter(List<Item> items) {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(4), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        ImageRecyclerAdapter adapter = new ImageRecyclerAdapter(items, DetailActivity.this);
        recyclerView.setAdapter(adapter);
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
