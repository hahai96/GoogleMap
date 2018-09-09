package com.example.ha_hai.googlemap.ui.detail;

import com.example.ha_hai.googlemap.ui.base.MvpPresenter;

/**
 * Created by ha_hai on 9/9/2018.
 */

public interface DetailMvpPresenter <V extends DetailMvpView> extends MvpPresenter<V> {

    void getImages(int id);
}
