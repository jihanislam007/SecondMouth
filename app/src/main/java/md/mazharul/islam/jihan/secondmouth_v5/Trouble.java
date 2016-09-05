package md.mazharul.islam.jihan.secondmouth_v5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Bundle;

import android.app.Activity;
import android.app.ProgressDialog;
import android.location.Location;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class Trouble extends Activity implements ConnectionCallbacks,
        OnConnectionFailedListener, LocationListener {
    ProgressDialog pb;

    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;

    public Location mLastLocation;

    private GoogleApiClient mGoogleApiClient;

    private boolean mRequestingLocationUpdates = false;

    private LocationRequest mLocationRequest;

    private static int UPDATE_INTERVAL = 10000; // 10 sec
    private static int FATEST_INTERVAL = 5000; // 5 sec
    private static int DISPLACEMENT = 1; // 1 meters

    private TextView location;
    private Button btnShowLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trouble);

        location = (TextView) findViewById(R.id.lblLocation);
        btnShowLocation = (Button) findViewById(R.id.btnShowLocation);





        if (checkPlayServices()) {

            buildGoogleApiClient();

            createLocationRequest();
        }
        btnShowLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayLocation();
                togglePeriodicLocationUpdates();

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        checkPlayServices();

        if (mGoogleApiClient.isConnected() && mRequestingLocationUpdates) {
            startLocationUpdates();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopLocationUpdates();
    }

    private void displayLocation() {


        //////////////////////////////////////////////////////

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
            mLastLocation = LocationServices.FusedLocationApi
                    .getLastLocation(mGoogleApiClient);
        }

        //////////////////////////////////////////////////////

       /* mLastLocation = LocationServices.FusedLocationApi
                .getLastLocation(mGoogleApiClient);*/


       /* lati =  mLastLocation.getLatitude();
       double longi = mLastLocation.getLongitude();*/

        if (mLastLocation != null) {
            double latitude = mLastLocation.getLatitude();
            double longitude = mLastLocation.getLongitude();

            // location.setText("lat-lng: " + latitude + ", " + longitude);
            new GetAddress().execute(latitude, longitude);
        } else {

            location
                    .setText("(Couldn't get the location. Make sure location is enabled on the device)");
        }

    }



    class GetAddress extends AsyncTask<Double, Void, Void> {

        String result = null;

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            pb.dismiss();
            try {
                location.append("\nYour current Address is : "
                        + myAddresFormat(Geocoding_suport.str1, Geocoding_suport.str2));

                //////////////////////////////////////////////////////////////////////////

              /*  SmsManager smsManager = SmsManager.getDefault();

                smsManager.sendTextMessage(( sendphone.getText().toString()), null, (myAddresFormat(Geocoding_suport.str1, Geocoding_suport.str2)), null, null);;

*/

                Button sender = (Button) findViewById(R.id.buttonsendermess);
                sender.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                 //       EditText sendphone = (EditText) findViewById(R.id.editTextsendmess);

                       /* if (sendphone.getText().toString().equals("")) {

                            Toast toast = Toast.makeText(Trouble.this,"Please Give Me Input!", Toast.LENGTH_LONG);

                            toast.show();

                        }
                        else
                        {*/

                            SharedPreferences sharedpreferences;
                            sharedpreferences = getSharedPreferences("file1" , MODE_PRIVATE);
                            String phoneu = sharedpreferences.getString("phonekey","No Data");

                        //    String obj=sendphone.getText().toString();

                            Intent send = new Intent(Trouble.this, Massage_confirme.class);

                            send.putExtra("PERSON_NAME", phoneu);
                            startActivity(send);

                        }


                        //     Toast.makeText(getApplicationContext(), "phoneno" + phoneno, Toast.LENGTH_LONG).show();

                 //   }
                });
///////////////////////////////////////////////////////////////////////////////////
            } catch (IndexOutOfBoundsException e) {

            } catch (Exception e) {

            }
        }



        public String myAddresFormat(String s1, String s2)
                throws IndexOutOfBoundsException, Exception {

            final String splitter = ", ";
            String address[] = s2.split(splitter);

            return address[0] + ", " + s1;
        }

        public String myAddresFormat(String s)
                throws IndexOutOfBoundsException, Exception {

            String spliter = ",";
            String address[] = s.split(spliter);

            return address[0] + spliter + address[1] + spliter + address[2];
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb = new ProgressDialog(Trouble.this);
            pb.setTitle("Recognizing your address...");
            pb.show();

        }

        @Override
        protected Void doInBackground(Double... params) {

            Geocoding_suport parse = new Geocoding_suport();

            parse.execute("" + params[0], "" + params[1]);

            return null;
        }

    }

    private void togglePeriodicLocationUpdates() {
        if (!mRequestingLocationUpdates) {

            mRequestingLocationUpdates = true;

            startLocationUpdates();

        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
    }

    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(UPDATE_INTERVAL);
        mLocationRequest.setFastestInterval(FATEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setSmallestDisplacement(DISPLACEMENT);
    }

    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "This device is not supported.", Toast.LENGTH_LONG)
                        .show();
                finish();
            }
            return false;
        }
        return true;
    }

    protected void startLocationUpdates() {

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
            LocationServices.FusedLocationApi.requestLocationUpdates(
                    mGoogleApiClient, mLocationRequest, this);
        }



    }

    protected void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mGoogleApiClient, this);
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Toast.makeText(getApplicationContext(), "Connection Failed",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnected(Bundle arg0) {

        // Once connected with google api, get the location
        displayLocation();

        if (mRequestingLocationUpdates) {
            startLocationUpdates();
        }
    }

    @Override
    public void onConnectionSuspended(int arg0) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;

        displayLocation();
    }

    /////////////////////////////////work for menue////////////////////////////////////////////////
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.trouble, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.trouble) {
            // return true;
            startActivity(new Intent(this,Trouble.class));
        }
        else if(id==R.id.location){
            startActivity(new Intent(this,MapsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}