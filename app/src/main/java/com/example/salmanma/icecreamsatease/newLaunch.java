package com.example.salmanma.icecreamsatease;
//new launches activity
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;


public class newLaunch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new New())
                .commit();

    }


}
