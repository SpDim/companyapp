package com.example.companyapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

public class CompanyActivity extends Activity {

    public static final String COMPANY_LAT = "37.984415";
    public static final String COMPANY_LON = "23.728261";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager locMgr = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            }, 0);
            return;
        }

        Location loc = locMgr.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        Toast.makeText(getApplicationContext(), "CLIENT  : " + loc.getLatitude() + " " + loc.getLongitude(), Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "COMPANY : " + COMPANY_LAT + " " + COMPANY_LON, Toast.LENGTH_LONG).show();
    }
}
