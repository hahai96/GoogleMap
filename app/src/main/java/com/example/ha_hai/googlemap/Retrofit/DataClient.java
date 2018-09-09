package com.example.ha_hai.googlemap.Retrofit;

import com.example.ha_hai.googlemap.Retrofit.places.FoursquareJSON;
import com.example.ha_hai.googlemap.Retrofit.image.ImageLocation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ha_hai on 9/9/2018.
 */

public interface DataClient {

    @GET("search/recommendations?v=20180323")
    Call<FoursquareJSON> searchCoffee(@Query("client_id") String clientID,
                                      @Query("client_secret") String clientSecret,
                                      @Query("ll") String ll,
                                      @Query("llAcc") double llAcc,
                                      @Query("query") String query
    );


    @GET("venues/" + "50e101cee4b083ca7c3ee122" + "/photos?v=20180323")
    Call<ImageLocation> searchImage(@Query("client_id") String clientID,
                                    @Query("client_secret") String clientSecret);
}
