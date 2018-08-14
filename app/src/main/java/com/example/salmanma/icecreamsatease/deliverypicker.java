package com.example.salmanma.icecreamsatease;
//this class is for setting delivery location
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
public class deliverypicker extends AppCompatActivity  {
    private Intent i1;
    private int PLACE_PICKER_REQUEST=1;
    private SharedPreferences deliv;
    boolean ds=false;
    private TextView update;
    private Button sknxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_delivpick);
        deliv = this.getSharedPreferences(
                "delivery", Context.MODE_PRIVATE);
        update=(TextView)findViewById(R.id.chts);
        sknxt=(Button)findViewById(R.id.sknxt);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlacePicker.IntentBuilder builder1 = new PlacePicker.IntentBuilder();
                try{
                    i1=builder1.build(deliverypicker.this);
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        i1.putExtra("primary_color", ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                        i1.putExtra("primary_color_dark", ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
                    }
                    startActivityForResult(i1,PLACE_PICKER_REQUEST);
                }
                catch (GooglePlayServicesRepairableException e)
                {
                    e.printStackTrace();
                }
                catch (GooglePlayServicesNotAvailableException e)
                {
                    e.printStackTrace();
                }
            }
        });
        sknxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent re=new Intent();
                if(ds)
                 setResult(Activity.RESULT_OK,re);
                else
                    setResult(Activity.RESULT_CANCELED,re);
                finish();
            }
        });
        PlacePicker.IntentBuilder builder1 = new PlacePicker.IntentBuilder();
        try{
            i1=builder1.build(deliverypicker.this);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                i1.putExtra("primary_color", ContextCompat.getColor(this, R.color.colorPrimary));
                i1.putExtra("primary_color_dark", ContextCompat.getColor(this, R.color.colorPrimaryDark));
            }
            startActivityForResult(i1,PLACE_PICKER_REQUEST);
        }
        catch (GooglePlayServicesRepairableException e)
        {
            e.printStackTrace();
        }
        catch (GooglePlayServicesNotAvailableException e)
        {
            e.printStackTrace();
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                ds = true;
                Place place = PlacePicker.getPlace(deliverypicker.this, i1);
                Toast.makeText(deliverypicker.this, "in onActivityResult ...", Toast.LENGTH_SHORT).show();
                try {
                    deliv.edit().putString("Place name", (String) place.getName())
                            .putString("Address", (String) place.getAddress())
                            .putString("Lat long", String.valueOf(place.getLatLng().latitude) +
                                    String.valueOf(place.getLatLng().longitude)).apply();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                }
            }
            validate();
        }

    public void validate()
    {
        if(ds)
        {
            update.setBackgroundResource(R.color.Success);
            update.setText("Completed the setup of delivery location|Click here to edit");
            sknxt.setText("Next");
        }
        else
        {
            update.setBackgroundResource(R.color.errorColor);
            update.setText("Delivery location is not yet provided.......Click here to setup");
            sknxt.setText("Skip");

        }
    }


}
