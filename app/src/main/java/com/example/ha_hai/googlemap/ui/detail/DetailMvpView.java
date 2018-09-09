package com.example.ha_hai.googlemap.ui.detail;

import com.example.ha_hai.googlemap.Retrofit.image.Item;
import com.example.ha_hai.googlemap.ui.base.MvpView;

import java.util.List;

public interface DetailMvpView extends MvpView {

    void setAdapter(List<Item> items);
}
