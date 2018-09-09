package com.example.ha_hai.googlemap.ui.places;

import android.location.Location;

import com.example.ha_hai.googlemap.ui.base.MvpPresenter;

public interface PlacesNearMvpPresenter<V extends PlacesNearMvpView> extends MvpPresenter<V> {

    void getPlacesNear(Location location, String query);

}