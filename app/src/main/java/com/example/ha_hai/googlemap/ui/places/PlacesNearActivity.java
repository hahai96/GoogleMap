package com.example.ha_hai.googlemap.ui.places;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ha_hai.googlemap.R;
import com.example.ha_hai.googlemap.Retrofit.POJO.FoursquareResults;
import com.example.ha_hai.googlemap.adapter.PlacesNearAdapter;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlacesNearActivity extends AppCompatActivity implements PlacesNearMvpView{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    PlacesNearPresenter placesNearPresenter;
    private FusedLocationProviderClient mFusedLocationClient;

    private String query = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_near);

        ButterKnife.bind(this);

        query = getIntent().getStringExtra("query");

        placesNearPresenter = new PlacesNearPresenter();
        placesNearPresenter.onAttach(PlacesNearActivity.this);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (checkPermission())
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {

                            placesNearPresenter.getPlacesNear(location, query);
                        }
                    });


    }

    @Override
    public void setAdapter(List<FoursquareResults> items) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        PlacesNearAdapter adapter = new PlacesNearAdapter(items, PlacesNearActivity.this);
        recyclerView.setAdapter(adapter);
    }

    private boolean checkPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

}
