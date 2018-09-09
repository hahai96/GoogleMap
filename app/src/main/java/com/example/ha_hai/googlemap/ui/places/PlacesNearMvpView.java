package com.example.ha_hai.googlemap.ui.places;

import com.example.ha_hai.googlemap.Retrofit.places.FoursquareResults;
import com.example.ha_hai.googlemap.ui.base.MvpView;

import java.util.List;

public interface PlacesNearMvpView extends MvpView {

    void setAdapter(List<FoursquareResults> items);

}