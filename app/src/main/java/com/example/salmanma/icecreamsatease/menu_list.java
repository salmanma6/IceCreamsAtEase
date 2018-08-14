package com.example.salmanma.icecreamsatease;
//main menu activity
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;


public class menu_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MainMenu())
                .commit();

    }


}
