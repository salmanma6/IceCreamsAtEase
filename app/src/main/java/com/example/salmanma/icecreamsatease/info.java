package com.example.salmanma.icecreamsatease;
//class for fetching basic details
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class info extends AppCompatActivity  {
    private String age="",gen="";
    private pl.droidsonroids.gif.GifImageView a;
    private TextView ret,txt;
    private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_info);
        final SharedPreferences genage= getApplicationContext().getSharedPreferences("genage", Context.MODE_PRIVATE);
        final Button skip,next;
        final TextView male,female,one,two,three;
        dialog= new Dialog(info.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialogueforinternet);
        a=(pl.droidsonroids.gif.GifImageView)dialog.findViewById(R.id.gifdinternchk);
        ret=(TextView)dialog.findViewById(R.id.retyinintern);
        txt=(TextView)dialog.findViewById(R.id.txtininternck);
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               checkintern();
            }
        });
        male=(TextView)findViewById(R.id.genmale);
        female=(TextView)findViewById(R.id.genfemale);
        one=(TextView)findViewById(R.id.ageadol);
        two=(TextView)findViewById(R.id.ageadult);
        three=(TextView)findViewById(R.id.ageunc);
        skip=(Button)findViewById(R.id.skiinfo);
        next=(Button)findViewById(R.id.nxtinfo);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(info.this,interlocpanel.class));
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(age.equals("") && gen.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please make sure you entered details",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Details fetched",Toast.LENGTH_SHORT).show();
                    genage.edit().putString("Gender",gen).putString("Age",age).apply();
                    SharedPreferences firsttime=getApplicationContext().getSharedPreferences("firsttime",MODE_PRIVATE);
                    firsttime.edit().putBoolean("info",true).apply();
                    startActivity(new Intent(info.this,interlocpanel.class));

                }

            }
        });
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gen="male";
             male.setTextColor(getResources().getColor(R.color.White));
             male.setBackgroundResource(R.drawable.layoutforbuttons4);
                female.setTextColor(getResources().getColor(R.color.black));
                female.setBackgroundResource(R.drawable.layoutforbuttons3);
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gen="female";
                female.setTextColor(getResources().getColor(R.color.White));
                female.setBackgroundResource(R.drawable.layoutforbuttons4);
                male.setTextColor(getResources().getColor(R.color.black));
                male.setBackgroundResource(R.drawable.layoutforbuttons3);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age="<18";
                one.setTextColor(getResources().getColor(R.color.White));
                one.setBackgroundResource(R.drawable.layoutforbuttons4);
                two.setTextColor(getResources().getColor(R.color.black));
                two.setBackgroundResource(R.drawable.layoutforbuttons3);
                three.setTextColor(getResources().getColor(R.color.black));
                three.setBackgroundResource(R.drawable.layoutforbuttons3);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age="18-45";
                two.setTextColor(getResources().getColor(R.color.White));
                two.setBackgroundResource(R.drawable.layoutforbuttons4);
                one.setTextColor(getResources().getColor(R.color.black));
                one.setBackgroundResource(R.drawable.layoutforbuttons3);
                three.setTextColor(getResources().getColor(R.color.black));
                three.setBackgroundResource(R.drawable.layoutforbuttons3);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age=">45";
                three.setTextColor(getResources().getColor(R.color.White));
                three.setBackgroundResource(R.drawable.layoutforbuttons4);
                two.setTextColor(getResources().getColor(R.color.black));
                two.setBackgroundResource(R.drawable.layoutforbuttons3);
                one.setTextColor(getResources().getColor(R.color.black));
                one.setBackgroundResource(R.drawable.layoutforbuttons3);
            }
        });
        Runnable r = new Runnable() {
            @Override
            public void run(){
                checkintern();
            }
        };
        Handler h = new Handler();
        h.postDelayed(r, 1000);
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public void checkintern()
    {
        a.setVisibility(View.VISIBLE);
        txt.setText("Checking internet connection");
        txt.setBackgroundResource(R.color.md_blue_400);
        ret.setVisibility(View.GONE);
        dialog.show();
        Runnable ra = new Runnable() {
            @Override
            public void run(){
        if(isNetworkAvailable())
        {

            a.setVisibility(View.GONE);
            ret.setVisibility(View.GONE);
            txt.setText("   Connected   ");
            txt.setBackgroundResource(R.color.md_green_400);
            Runnable r = new Runnable() {
                @Override
                public void run(){
                    dialog.dismiss();
     statusCheck();
                }
            };
            Handler h = new Handler();
            h.postDelayed(r, 2000);
        }
        else
        {
            a.setVisibility(View.GONE);
            ret.setVisibility(View.VISIBLE);
            txt.setBackgroundResource(R.color.md_red_400);
            txt.setText("No internet connection");
        }

            }
        };
        Handler ha = new Handler();
        ha.postDelayed(ra, 2000);
    }
    public void statusCheck() {
        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();

        }
    }
    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Location Settings")
                .setIcon(R.drawable.userloc)
                .setMessage("Your GPS seems to be disabled,do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        final Dialog d=(Dialog)dialog;
                        d.dismiss();
                        final AlertDialog.Builder builder1 = new AlertDialog.Builder(getApplicationContext());
                        builder1.setTitle("Caution!")
                                .setIcon(R.drawable.caut)
                                .setMessage("Your present location will not be shown.Do you want to continue")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(final DialogInterface dialog, final int id) {

                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(final DialogInterface dialog, final int id) {
                                        d.show();

                                    }
                                });
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }
    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
