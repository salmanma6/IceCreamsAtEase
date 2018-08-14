package com.example.salmanma.icecreamsatease;
import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Interpolator;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.Manifest;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.maps.android.MarkerManager;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import static com.example.salmanma.icecreamsatease.R.id.toolbar;
import static com.example.salmanma.icecreamsatease.R.id.toolbarinMain;

public class mainicemap extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener, ClusterManager.OnClusterItemClickListener<Shop>,ClusterManager.OnClusterClickListener {
    static GoogleMap mMap;
    private int iconid;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private Dialog dialogshort, dialog2;
    private TextView msgok,msgdontshow;
    private Marker user;
    private DrawerLayout drawerLayout;
    public static String snack;
    static ArrayList<Shop> sjops;
    private ArrayList<Marker> mrks;
    private Boolean locationfound = false;
    LocationRequest mLocationRequest;
    SharedPreferences ggshrt;
    static BottomSheetDialogFragment bottomSheetDialogFragment;
    //private SharedPreferences userlocdet ;
    //private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_mainicemap);
        buildGoogleApiClient();
        mGoogleApiClient.connect();
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        TextView ggsnk=(TextView)findViewById(R.id.shopzonespec);
        ggsnk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMarkerList();
            }
        });
        TextView sssknd=(TextView)findViewById(R.id.zoomout);
        sssknd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.animateCamera(CameraUpdateFactory.zoomTo(10),2500,null);
            }
        });
        dialogshort = new Dialog(mainicemap.this);
        dialogshort.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogshort.setCancelable(false);
        dialogshort.setContentView(R.layout.dialogue_tinyguide);
        // statusCheck();
        dialog2 = new Dialog(mainicemap.this);
        dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog2.setCancelable(true);
        dialog2.setContentView(R.layout.dialogue_shopmrkclick);
        ggshrt=getSharedPreferences("shortguideopen",MODE_PRIVATE);
        msgok = (TextView)dialogshort.findViewById(R.id.okinshortguide);
        msgdontshow= (TextView)dialogshort.findViewById(R.id.dsanshort);
        msgok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   dialogshort.dismiss();
            }
        });
        msgdontshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ggshrt.edit().putBoolean("Dont",true).apply();
                dialogshort.dismiss();
            }
        });
        Toast.makeText(getApplicationContext(), "In onMapcreate after api build", Toast.LENGTH_LONG).show();
        SharedPreferences genage = this.getSharedPreferences(
                "genage", Context.MODE_PRIVATE);
        String gender, age;
        gender = genage.getString("Gender", "male");
        age = genage.getString("Age", "18-45");
        switch (age) {
            case "<18":
                if (gender.equals("male")) {
                    iconid = R.drawable.boy;
                    break;
                } else if (gender.equals("female")) {
                    iconid = R.drawable.girl;
                    break;
                }
            case "18-45":
                if (gender.equals("male")) {
                    iconid = R.drawable.gentleman;
                    break;
                } else if (gender.equals("female")) {
                    iconid = R.drawable.lady;
                    break;
                }
            case ">45":
                if (gender.equals("male")) {
                    iconid = R.drawable.uncle;
                    break;
                } else if (gender.equals("female")) {
                    iconid = R.drawable.aunt;
                    break;
                }
            default:
                iconid = R.drawable.gentleman;

        }
    }
    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }
    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(this)
                        .setTitle("Location Permission Needed")
                        .setMessage("This app needs the Location permission, please accept to use location functionality")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(mainicemap.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION );
                            }
                        })
                        .create()
                        .show();


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION );
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Toast.makeText(getApplicationContext(), "In onMapReady", Toast.LENGTH_LONG).show();
        MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(this, R.raw.pink);
        mMap.setMapStyle(mapStyleOptions);
        LatLng latLng = new LatLng(17.428234,78.442698);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("You");
        markerOptions.icon(BitmapDescriptorFactory.fromResource(iconid));
        user= mMap.addMarker(markerOptions);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                //Location Permission already granted
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            } else {
                //Request Location Permission
                checkLocationPermission();
            }
        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
        LatLng huu = new LatLng(17.425403, 78.471891);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(huu));
        try {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("shops");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    sjops = new ArrayList<>();
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                        Shop shap = postSnapshot.getValue(Shop.class);
                        sjops.add(shap);
                    }
                    Toast.makeText(getApplicationContext(), "completed on data change", Toast.LENGTH_LONG).show();
                    markerset();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(), "Error in setting shops", Toast.LENGTH_LONG).show();
                    return;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "completed onMapReady", Toast.LENGTH_LONG).show();
    }

    public void markerset() {
        try {
            ClusterManager<Shop> mClusterManager = new ClusterManager<>(this, mMap);
            mMap.setOnCameraIdleListener(mClusterManager);
            mMap.setOnMarkerClickListener(mClusterManager);
            mClusterManager.setOnClusterItemClickListener(this);
            for (Shop e : sjops) {
                mClusterManager.addItem(e);
            }
            try {
                mClusterManager.setOnClusterClickListener(this);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            mClusterManager.setRenderer(new OwnIconRendered(getApplicationContext(), mMap, mClusterManager));
            mClusterManager.cluster();
            Toast.makeText(getApplicationContext(),"Done adding markers",Toast.LENGTH_LONG).show();
            Runnable r = new Runnable() {
                @Override
                public void run(){
                    if(!ggshrt.getBoolean("Dont",false))
                        dialogshort.show();
                }
            };
            Handler h = new Handler();
            h.postDelayed(r, 2000);
            bottomSheetDialogFragment = new DialogFragment();
            showMarkerList();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void showMarkerList()
    {
        bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
    }
    @Override
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();

    }
    @Override
    protected void onStop() {
        // Disconnecting the client invalidates it.
        mGoogleApiClient.disconnect();
        super.onStop();
    }
    @Override
    public void onConnected(Bundle bundle) {

             /*   Double lat=mLastLocation.getLatitude();
                Double lng=mLastLocation.getLongitude();
                ul = new LatLng(lat, lng);
                MarkerOptions useroptions=new MarkerOptions().position(ul).title("You").icon(BitmapDescriptorFactory.fromResource(iconid));
                if(mMap!=null)
                    user = mMap.addMarker(useroptions);
                    user.showInfoWindow();
                    animateMarker(user, ul, false);*/
        Toast.makeText(getApplicationContext(),"In Location Connected",Toast.LENGTH_LONG).show();
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            try {
                LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
                }

@Override
public void onConnectionSuspended(int i) {
        Toast toast = Toast.makeText(getApplicationContext(),"Connection to Google Play Services Suspended", Toast.LENGTH_LONG);
        toast.show();
        }
@Override
public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast toast = Toast.makeText(getApplicationContext(),"Connection to Google Play Services failed", Toast.LENGTH_LONG);
        toast.show();
        }
@Override
public void onLocationChanged(Location location) {
        /*for storing data in shared preferences
        editor.putString("Latitude", Double.toString(location.getLongitude()));
        Toast.makeText(getApplicationContext(),"In onLocationChanged",Toast.LENGTH_LONG).show();
    Double lat=location.getLatitude();
    Double lng=location.getLongitude();
    ul = new LatLng(lat, lng);
    animateMarker(user,ul,false);*/
        Toast.makeText(getApplicationContext(),"In onLocationChanged",Toast.LENGTH_LONG).show();
    mLastLocation = location;
    if (user != null) {
        user.remove();
    }
    LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
    MarkerOptions markerOptions = new MarkerOptions();
    markerOptions.position(latLng);
    markerOptions.title("You");
    markerOptions.icon(BitmapDescriptorFactory.fromResource(iconid));
    user= mMap.addMarker(markerOptions);

}
    @Override
    public void onBackPressed() {
        finishAffinity();
    }
    public  static void showMessage(Activity activity) {
        View rootView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar.make(rootView,snack, Snackbar.LENGTH_LONG).show();
    }
    private void openShop(Shop marker) {
        dialog2.show();
        final Shop mark=marker;
        TextView shpnma=(TextView)dialog2.findViewById(R.id.shpnameinmap);
		ImageView shlog=(ImageView)dialog2.findViewById(R.id.shplogo);
        try {
            switch (marker.getTitle()) {
                case ("Baskin Robbins"):
                    shlog.setImageResource(R.drawable.br);
                    break;
                case ("Famous Icecreams"):
                    shlog.setImageResource(R.drawable.famous);
                    break;
                case ("Dairy Den"):
                    shlog.setImageResource(R.drawable.dairyden);
                    break;
                case ("Darley Icecreams"):
                    shlog.setImageResource(R.drawable.darley);
                    break;
                case ("Dr.Icecream"):
                    shlog.setImageResource(R.drawable.drice);
                    break;
                case ("Mist ND Creams"):
                    shlog.setImageResource(R.drawable.mist);
                    break;
                case ("Ibaco Icecreams"):
                    shlog.setImageResource(R.drawable.ibaco);
                    break;
                case ("Arun Icecreams"):
                    shlog.setImageResource(R.drawable.arun);
                    break;
                case ("Havmor"):
                    shlog.setImageResource(R.drawable.havmor);
                    break;
                case ("Masqati Icecreams"):
                    shlog.setImageResource(R.drawable.masqati);
                    break;
                case ("Amore Gelato"):
                    shlog.setImageResource(R.drawable.amore);
                    break;
                case ("Naturals"):
                    shlog.setImageResource(R.drawable.naturals);
                    break;
                case ("Cream Stone"):
                    shlog.setImageResource(R.drawable.crmstone);
                    break;
                case ("Ice Kraft"):
                    shlog.setImageResource(R.drawable.icecra);
                    break;
                case ("Indulge Icecreams"):
                    shlog.setImageResource(R.drawable.indul);
                    break;
                default:
                    shlog.setImageResource(R.drawable.defice);
            }
            TextView shprat = (TextView) dialog2.findViewById(R.id.shprating);
            for (Shop e : sjops) {
                if (marker.getTag().equals(e.getTag())) {
                    if (e.getRating() != null) {
                        String rate = "Good";
                        switch (e.getRating()) {
                            case "good":
                                rate = "Rating:Good";
                                break;
                            case "verygood":
                                rate = "Rating:Very Good";
                                break;
                        }
                        shprat.setText(rate);
                        break;
                    }
                }
            }
            shpnma.setText(mark.getTitle());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        LinearLayout prd,pic,dir;
        prd=(LinearLayout)dialog2.findViewById(R.id.viewproducts);
        pic=(LinearLayout)dialog2.findViewById(R.id.viewphotos);
        dir=(LinearLayout)dialog2.findViewById(R.id.getdirections);
		TextView hd=(TextView)dialog2.findViewById(R.id.cancelmarker);
		 hd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				
			  dialog2.dismiss();
            }
        });
        prd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				if(mark.getTitle().equals("Baskin Robbins")	)
                    startActivity(new Intent(mainicemap.this,settingshop.class));
			    else   
			    {
			      Toast.makeText(getApplicationContext(),"This shop's products are currently not available",Toast.LENGTH_LONG).show(); 
				}
            }
        });
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    showPics(mark);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        dir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Uri gmmIntentUri = Uri.parse("google.navigation:q=" + mark.getPosition().latitude + "," + mark.getPosition().longitude);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
					if (mapIntent.resolveActivity(getPackageManager()) != null) {
                     startActivity(mapIntent); 
                     }
                    else
					{
					Toast.makeText(getApplicationContext(),"It seems you dont have GoogleMaps Application",Toast.LENGTH_LONG).show(); 
	
					}
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

    }
    public void showPics(Shop marker)
    {   String imglink="";
        try {
            for (Shop e : sjops) {
                if (marker.getTag().equals(e.getTag())) {
                    imglink = e.getPhotos();
					break;
                }
            }
            if (imglink != null)
            {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(imglink));
			  if (browserIntent.resolveActivity(getPackageManager()) != null) {
               startActivity(browserIntent);
               }
			   else
			   {
				   			      Toast.makeText(getApplicationContext(),"It seems you dont have Internet Browser",Toast.LENGTH_LONG).show();

			   }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onClusterItemClick(Shop shop) {
        if(shop!=null)
        {
            mMap.moveCamera(CameraUpdateFactory.newLatLng(shop.getPosition()));
            if(shop.getTitle().equals("You"))
            {
                return true;
            }
            else {
                openShop(shop);

            }
        }
        return true;
    }

    @Override
    public boolean onClusterClick(Cluster cluster) {
        Toast.makeText(getApplicationContext(),"Please Zoom in",Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
