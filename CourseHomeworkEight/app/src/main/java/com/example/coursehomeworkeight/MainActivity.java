package com.example.coursehomeworkeight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterManager;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap map;
    private ClusterManager<MyItem> clusterManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    private void setUpClusterer() {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(45, 34.35), 10));

        clusterManager = new ClusterManager<>(this, map);

        map.setOnCameraIdleListener(clusterManager);
        map.setOnMarkerClickListener(clusterManager);

        addItems();
    }

    private void addItems() {

        double lat = 45;
        double lng = 34.35;

        for (int i = 0; i < 100; i++) {
            double offset = i / 8000d;
            lat = lat + offset;
            lng = lng + offset;
            MyItem offsetItem = new MyItem(lat, lng, "Title " + i, "Snippet " + i);
            clusterManager.addItem(offsetItem);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        setUpClusterer();

    }
}