package com.example.ha_hai.googlemap.ui.base;

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

}