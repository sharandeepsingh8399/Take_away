package com.example.sharan.take_away;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Taranpreet Singh on 01/11/2016.
 */
public class GPS extends Service implements LocationListener {

    private final Context _Context;

    boolean isGPSEnabled = false;

    boolean isNetworkEnabled = false;

    boolean canGetLocation = false;

    Geocoder geoCoder;

    Location location; // location
    double latitude; // latitude
    double longitude; // longitude
    float speed; //speed
    double altitude; //altitude
    double bearing;//bearing
    float accuracy;//accuracy
    LocationManager locationManager;


    public float getLocationDistance(double userLat, double userLong, double endLat, double endLong) {
        try {
            float[] result = new float[5];
            location.distanceBetween(userLat, userLong, endLat, endLong, result);
            Log.i("Distance Result", String.valueOf(result[0]));
            Log.i("Distance Result", String.valueOf(result[1]));
            Log.i("Distance Result", String.valueOf(result[2]));
            return result[0];
        } catch (Exception e) {
            Log.i("Shit", "happen");
        }
        return 1;
    }

    List<Address> listAddresses;

    // The minimum distance to change Updates in meters
    private static final long minDistanceUpt = 10; // 10 meters

    // The minimum time between updates in milliseconds
    private static final long minTime = 1000 * 60 * 1; // 1 minute

    public GPS(Context context) {
        this._Context = context;
        getLocation();
    }

    public Location getLocation() {
        try {
            locationManager = (LocationManager) _Context.getSystemService(LOCATION_SERVICE);

            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNetworkEnabled) {
            } else {
                this.canGetLocation = true;
                if (isNetworkEnabled) {

                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, minTime, minDistanceUpt, this);
                    Log.i("Network", "Network");
                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                        }
                    }
                }
                if (isGPSEnabled) {
                    if (location == null) {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistanceUpt, this);
                        Log.i("GPS Enabled", "GPS Enabled");
                        if (locationManager != null) {
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return location;
    }

    public void stopUsingGPS() {
        if (locationManager != null) {

            locationManager.removeUpdates(GPS.this);
        }
    }

    public double getLatitude() {
        if (location != null) {
            latitude = location.getLatitude();
        }
        return latitude;
    }

    public double getLongitude() {
        if (location != null) {
            longitude = location.getLongitude();
        }
        return longitude;
    }

    public float getSpeed() {
        if (location != null) {
            speed = location.getSpeed();
        }
        return speed;
    }

    public double getAltitude() {
        if (location != null) {
            altitude = location.getAltitude();
        }
        return altitude;
    } //altitude

    public double getBearing() {
        if (location != null) {
            bearing = location.getBearing();
        }
        return bearing;
    }

    public float getAccuracy() {
        if (location != null) {
            accuracy = location.getAccuracy();
        }
        return accuracy / 1000;
    }

    public String getAddress() {
        String addressHolder = "";

        try {
            geoCoder = new Geocoder(this._Context, Locale.getDefault());

            listAddresses = geoCoder.getFromLocation(this.getLatitude(), this.getLongitude(), 1);

            if (listAddresses != null && listAddresses.size() > 0) {
                Log.i("PlaceInfo", listAddresses.get(0).toString());
            }

            for (int i = 0; i < listAddresses.get(0).getMaxAddressLineIndex(); i++) {
                addressHolder += listAddresses.get(0).getAddressLine(i) + "\n";
            }

            Log.i("Address :", addressHolder);
            return addressHolder;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error Occur.";
    }

    public String getAddress(double lat, double lon) {
        String addressHolder = "";
        try {
            geoCoder = new Geocoder(this._Context, Locale.getDefault());

            listAddresses = geoCoder.getFromLocation(lat, lon, 1);

            if (listAddresses != null && listAddresses.size() > 0) {
                Log.i("PlaceInfo", listAddresses.get(0).toString());
            }

            for (int i = 0; i < listAddresses.get(0).getMaxAddressLineIndex(); i++) {
                addressHolder += listAddresses.get(0).getAddressLine(i) + "\n";
            }

            Log.i("Address :", addressHolder);
            return addressHolder;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error Occur.";
    }

    public String getStateName() {
        String stringName = "";
        try {
            geoCoder = new Geocoder(this._Context, Locale.getDefault());

            listAddresses = geoCoder.getFromLocation(this.getLatitude(), this.getLongitude(), 1);
            if (listAddresses != null && listAddresses.size() > 0) {
                Log.i("PlaceInfo", listAddresses.get(0).toString());
            }


            return listAddresses.get(0).getAdminArea();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringName;
    }

    public boolean canGetLocation() {
        return this.canGetLocation;
    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(_Context);

        // Setting Dialog Title
        alertDialog.setTitle("GPS settings");

        // Setting Dialog Message
        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");

        // On pressing Settings button
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                _Context.startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    @Override
    public void onLocationChanged(Location location) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
}