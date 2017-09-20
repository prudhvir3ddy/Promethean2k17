package com.Promethean2k17.root.promethean2k17.Activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.Promethean2k17.root.promethean2k17.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int LOCATION_REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        requestPermission(Manifest.permission.ACCESS_FINE_LOCATION,
                LOCATION_REQUEST_CODE);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case LOCATION_REQUEST_CODE: {

                if (grantResults.length == 0
                        || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Unable to show location - permission required", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setMyLocationButtonEnabled(false);
        LatLng mainblock = new LatLng(17.725422, 78.257173);
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.727496, 78.254606)).title("Bvrit out gate"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.729512, 78.258218)).title("Bvrit in gate"));
        //mMap.addMarker(new MarkerOptions().position(new LatLng(17.727242, 78.254746)).title("Bvrit Security office"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.724345, 78.253530)).title("SWAMY VIVEKANANDA BOYS HOSTEL"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.725684, 78.253774)).title("Bvrit Daffodils 2"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.724685, 78.255195)).title("CSE,CHEM,MBA BLOCK"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.724750, 78.254712)).title("Main Block"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.727240, 78.254270)).title("SBH ATM"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.725151, 78.255791)).title("BVRIT FOOD COURT"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.725567, 78.256759)).title("Bvrit BOATING CLUB"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.725690, 78.257384)).title("CIVIL BLOCK"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.725932, 78.255051)).title("BVRIT AUDITORIUM"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.724631, 78.254107)).title("ECE EEE BME BLOCK"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.724979, 78.255829)).title("BVRIT DOSA POINT"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.725067, 78.256091)).title("BVRIT MAGGI AND COFFEE STATION"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.724348, 78.255575)).title("COOPERATIVE STORES"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.723911, 78.255486)).title("IT Block"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.723988, 78.255138)).title("MECHANICAL BLOCK"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.726168, 78.257072)).title("BVRIT LIBRARY"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.727174, 78.255681)).title("sports block"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.725231, 78.257152)).title("ASSISTIVE TECHNOLOGY LAB"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(17.723609, 78.255885)).title("BVRIT GIRLS HOSTEL"));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(17.724750, 78.254712), 18);
        mMap.animateCamera(cameraUpdate);
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

    }
    protected void requestPermission(String permissionType, int requestCode) {
        int permission = ContextCompat.checkSelfPermission(this,
                permissionType);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{permissionType}, requestCode
            );
        }
    }


        // Add a marker in Sydney and move the camera



}
