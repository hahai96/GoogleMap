package com.example.ha_hai.googlemap.ui.places;

import android.location.Location;
import com.example.ha_hai.googlemap.Utils.CommonUtils;
import com.example.ha_hai.googlemap.Retrofit.APIUltis;
import com.example.ha_hai.googlemap.Retrofit.DataClient;
import com.example.ha_hai.googlemap.Retrofit.places.FoursquareGroup;
import com.example.ha_hai.googlemap.Retrofit.places.FoursquareJSON;
import com.example.ha_hai.googlemap.Retrofit.places.FoursquareResponse;
import com.example.ha_hai.googlemap.Retrofit.places.FoursquareResults;
import com.example.ha_hai.googlemap.ui.base.BasePresenter;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlacesNearPresenter<V extends PlacesNearMvpView> extends BasePresenter<V> implements PlacesNearMvpPresenter<V> {

    @Override
    public void getPlacesNear(Location location, String query) {

        // The user's current latitude, longitude, and location accuracy
        String userLL = location.getLatitude() + "," + location.getLongitude();
        double userLLAcc = location.getAccuracy();

        DataClient dataClient = APIUltis.getData();
        Call<FoursquareJSON> callback = dataClient.searchCoffee(CommonUtils.client_id,
                CommonUtils.client_secret,
                userLL,
                userLLAcc, query);

        callback.enqueue(new Callback<FoursquareJSON>() {
            @Override
            public void onResponse(Call<FoursquareJSON> call, Response<FoursquareJSON> response) {
                // Gets the venue object from the JSON response
                FoursquareJSON fjson = response.body();
                FoursquareResponse fr = fjson.response;
                FoursquareGroup fg = fr.group;
                List<FoursquareResults> frs = fg.results;

                getMvpView().setAdapter(frs);
            }

            @Override
            public void onFailure(Call<FoursquareJSON> call, Throwable t) {

            }
        });
    }
}