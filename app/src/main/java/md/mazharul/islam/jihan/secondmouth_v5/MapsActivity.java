package md.mazharul.islam.jihan.secondmouth_v5;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends ActionBarActivity implements LocationListener {

    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        //To get MapFragment reference from xml layout
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);

        //To get map object
        map = mapFragment.getMap();

       /* //to show current location in the map
        map.setMyLocationEnabled(true);

        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                Toast.makeText(getApplicationContext(), latLng.toString(), Toast.LENGTH_LONG).show();
            }
        });*/

        //To setup location manager
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //To request location updates
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Check Permissions Now
           /* ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION);*/
        } else {
            // permission has been granted, continue as usual
            /*Location myLocation =
                    LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);*/
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1, 1, this);
        }



    }


    @Override
    public void onLocationChanged(Location location) {

        //To clear map data
        map.clear();

        //To hold location
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        //To create marker in map
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("My Location");
        //adding marker to the map
        map.addMarker(markerOptions);

        //opening position with some zoom level in the map
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17.0f));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}