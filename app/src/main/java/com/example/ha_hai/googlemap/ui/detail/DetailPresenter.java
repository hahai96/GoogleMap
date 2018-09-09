package com.example.ha_hai.googlemap.ui.detail;

import com.example.ha_hai.googlemap.Retrofit.APIUltis;
import com.example.ha_hai.googlemap.Retrofit.DataClient;
import com.example.ha_hai.googlemap.Retrofit.image.ImageLocation;
import com.example.ha_hai.googlemap.Retrofit.image.Item;
import com.example.ha_hai.googlemap.Retrofit.image.Photos;
import com.example.ha_hai.googlemap.Utils.CommonUtils;
import com.example.ha_hai.googlemap.ui.base.BasePresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ha_hai on 9/9/2018.
 */

public class DetailPresenter <V extends DetailMvpView> extends BasePresenter<V> implements DetailMvpPresenter<V> {

    @Override
    public void getImages(int id) {
        DataClient dataClient = APIUltis.getData();
        Call<ImageLocation> callback = dataClient.searchImage(CommonUtils.client_id, CommonUtils.client_secret);
        callback.enqueue(new Callback<ImageLocation>() {
            @Override
            public void onResponse(Call<ImageLocation> call, Response<ImageLocation> response) {
                ImageLocation json = response.body();
                com.example.ha_hai.googlemap.Retrofit.image.Response rp = json.getResponse();
                Photos photos = rp.getPhotos();
                List<Item> items = photos.getItems();

                getMvpView().setAdapter(items);
            }

            @Override
            public void onFailure(Call<ImageLocation> call, Throwable t) {

            }
        });
    }
}