package com.example.salmanma.icecreamsatease;
//favourites activity
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.salmanma.icecreamsatease.R.attr.layoutManager;

/**
 * Created by Salman M.A on 19-08-2017.
 */
public class favourites extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.cussharebon);
		 ImageView t=(ImageView)findViewById(R.id.images);
        /*toolbar = (Toolbar) findViewById(R.id.toolbarinfav);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout cp=(CollapsingToolbarLayout)findViewById(R.id.collaptbfav);
        cp.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),R.color.Menu));
        recyclerView=(RecyclerView)findViewById(R.id.listinfav);
        ArrayList<mcatnew> a1=new ArrayList<mcatnew>();
       // a1.add(new mcatnew(" Choco crackle ","Bar","₹40",R.drawable.chococrackle,R.color.Brown,"Baskin robbins"));
       // a1.add(new mcatnew(" Red velvet ","Cone","₹35",R.drawable.redvelvet,R.color.Pink,"Kwality walls"));
      //  a1.add(new mcatnew(" Spiral Mango ","Bar","₹15",R.drawable.spiral,R.color.yellow,"Arun icecreams"));
        adapter =new mnadptfav(a1);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);*/
    }

}

