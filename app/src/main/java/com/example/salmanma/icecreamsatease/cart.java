package com.example.salmanma.icecreamsatease;
//cart activity
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
/**
 * Created by Salman M.A on 19-08-2017.
 */
public class cart extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cussharebon);
        ImageView t = (ImageView) findViewById(R.id.images);
   /*
        toolbar = (Toolbar) findViewById(R.id.toolbarincart);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout cp=(CollapsingToolbarLayout)findViewById(R.id.collaptbcart);
        cp.setContentScrimColor(ContextCompat.getColor(getApplicationContext(),R.color.Menu));
        recyclerView=(RecyclerView)findViewById(R.id.listincart);
        ArrayList<mcatcart>  a1=new ArrayList<mcatcart>();
      //  a1.add(new mcatcart(" Falooda ","Family Pack","₹30","₹3","₹33",true,R.drawable.falooda,R.color.Pink));
       // a1.add(new mcatcart(" Cotton Candy ","Bar","₹20","₹3","₹23",true,R.drawable.cottoncandy,R.color.CyanBlue));
        adapter =new mnadptcart(a1);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);*/
    }
}
