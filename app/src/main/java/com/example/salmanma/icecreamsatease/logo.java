package com.example.salmanma.icecreamsatease;
//logo of app
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;
public class logo extends AppCompatActivity {
    ImageView tt;
    int logos[]={R.drawable.introand1,R.drawable.introand2,R.drawable.introand3
            ,R.drawable.introand5
           };
    private static String ma,pla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_logo);
        tt=(ImageView)findViewById(R.id.logimg);
        tt.setImageResource(logos[new Random().nextInt(4)]);
     /*   DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("keys");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                syek a=dataSnapshot.getValue(syek.class);
                ma=a.getMa();
                pla=a.getPla();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
        Runnable r = new Runnable() {
            @Override
            public void run(){
                nextintent();
            }
        };
        Handler h = new Handler();
        h.postDelayed(r, 1800);
    }
    public void nextintent()
    {
        SharedPreferences firsttime=getApplicationContext().getSharedPreferences("firsttime",MODE_PRIVATE);
        if(firsttime.getBoolean("info",false))
        {
            if(firsttime.getBoolean("interloc",false))
                startActivity(new Intent(logo.this,mainicemap.class));
            else
                startActivity(new Intent(logo.this,interlocpanel.class));
        }
        else {
            startActivity(new Intent(logo.this, info.class));
        }

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
