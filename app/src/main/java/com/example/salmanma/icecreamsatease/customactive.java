package com.example.salmanma.icecreamsatease;
//custom icecreams activity
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;


public class customactive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new Custom())
                .commit();

    }


}
