package com.example.ha_hai.googlemap.ui.replaces;

import android.location.Location;

import com.example.ha_hai.googlemap.Retrofit.POJO.FoursquareResults;
import com.example.ha_hai.googlemap.ui.base.MvpPresenter;

import java.util.List;

public interface PlacesNearMvpPresenter<V extends PlacesNearMvpView> extends MvpPresenter<V> {

    void getPlacesNear(Location location, String query);

}