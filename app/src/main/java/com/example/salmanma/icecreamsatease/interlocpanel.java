package com.example.salmanma.icecreamsatease;
//location main panel
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.os.*;
import android.content.*;
import android.view.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
public class interlocpanel extends AppCompatActivity {
    Intent ka,ak;
    int i=0;
    Button nxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_interlocpan);
  //      statusCheck();
        nxt=(Button)findViewById(R.id.sknxtinter);
        TextView backd=(TextView)findViewById(R.id.interlocclkbac);
        try{
        String sde=getIntent().getExtras().getString("From");

            if (sde.equals("MainActiv")) {
                nxt.setVisibility(View.GONE);
                backd.setVisibility(View.VISIBLE);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
       LinearLayout ff = (LinearLayout) findViewById(R.id.interlocshopse);
        LinearLayout gg = (LinearLayout) findViewById(R.id.interlocdeliv);
        SharedPreferences firsttime=getApplicationContext().getSharedPreferences("firsttime",MODE_PRIVATE);
        firsttime.edit().putBoolean("interloc",true).apply();
            nxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   startActivity(new Intent(interlocpanel.this,mainicemap.class));
                }
            });
           ff.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   ka=new Intent(interlocpanel.this, shopzone.class);
                   startActivityForResult(ka,1);
               }

           });
           gg.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Dialog dialog=new Dialog(interlocpanel.this);
                   dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                   dialog.setCancelable(false);
                   dialog.setContentView(R.layout.dialogueforloading);
                   pl.droidsonroids.gif.GifImageView a=(pl.droidsonroids.gif.GifImageView)dialog.findViewById(R.id.giffdinternchk);
                   a.setVisibility(View.GONE);
                   dialog.show();
                   ak=new Intent(interlocpanel.this, deliverypicker.class);
                   startActivityForResult(ak,1);
                   dialog.dismiss();
               }
           });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(data==ka) {
            if (requestCode == 1) {
                if (resultCode == Activity.RESULT_OK) {
                    i++;
                }
            }
        }
        if(data==ak){
            if (requestCode == 1) {
                if (resultCode == Activity.RESULT_OK) {
                    i++;
                }
            }
        }
        if(i==2)
        {
            nxt.setText("Next");
        }

    }

}

