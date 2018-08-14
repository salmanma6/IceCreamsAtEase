package com.example.salmanma.icecreamsatease;
//bonus activity
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;


public class bonusactive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new Bonus())
                .commit();

    }


}
