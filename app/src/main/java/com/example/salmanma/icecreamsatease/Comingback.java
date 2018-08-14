package com.example.salmanma.icecreamsatease;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Comingback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comingback);
        TextView t=(TextView)findViewById(R.id.gncm);
        t.setText("Coming Back...");
        Runnable r = new Runnable() {
            @Override
            public void run(){
                startActivity(new Intent(Comingback.this,mainicemap.class));
            }
        };
        Handler h = new Handler();
        h.postDelayed(r, 3500);
    }
}
