package com.example.ha_hai.googlemap.Retrofit;

/**
 * Created by ha_hai on 9/9/2018.
 */

public class APIUltis {

    public static final String Base_Url = "https://api.foursquare.com/v2/";

    //nhan va gui du lieu di/ve
    public static DataClient getData() {
        return RetrofitClient.getClient(Base_Url).create(DataClient.class);
    }
}
