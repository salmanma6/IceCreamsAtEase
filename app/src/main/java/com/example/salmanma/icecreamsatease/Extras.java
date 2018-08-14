package com.example.salmanma.icecreamsatease;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
public class Extras extends AppCompatActivity {
    private RecyclerView recyclerview;
    private DatabaseReference reference;
    private LinearLayoutManager layoutManager;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    int i=0,j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_icetypes);
        toolbar = (Toolbar) findViewById(R.id.toolbarinspice);
        toolbar.setTitle("Extras");
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Extras");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerview=(RecyclerView)findViewById(R.id.listspice);
        recyclerview.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(layoutManager);
        reference= FirebaseDatabase.getInstance().getReference().child("products").child("type").child("extras");
        FirebaseRecyclerAdapter<mcatnew,mnadptnew> adapter=new FirebaseRecyclerAdapter<mcatnew, mnadptnew>(mcatnew.class,R.layout.menufornew,mnadptnew.class,reference) {
            @Override
            protected void populateViewHolder(final mnadptnew viewHolder, mcatnew model, int position) {
                try {

                    viewHolder.linearlayout.setBackgroundResource(getResources().getIdentifier(model.getBack(), "color", getApplicationContext().getPackageName()));
                    viewHolder.pnam.setText(model.getName());
                    viewHolder.pcateg.setText(model.getCategory());
                    viewHolder.pprice.setText("Price:"+model.getPrice());
                    Picasso.with(getApplicationContext())
                            .load(model.getLink()).placeholder(R.drawable.defice).into(viewHolder.ppic);
                    viewHolder.loveclik.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(i==0)
                            {
                                viewHolder.loveclik.setImageResource(R.drawable.favo);
                                i++;
                            }
                            else if(i==1)
                            {
                                viewHolder.loveclik.setImageResource(R.drawable.favono);
                                i--;
                            }
                        }
                    });
                    viewHolder.cartclik.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(i==0)
                            {
                                viewHolder.cartclik.setImageResource(R.drawable.cart);
                                i++;
                            }
                            else if(i==1)
                            {
                                viewHolder.cartclik.setImageResource(R.drawable.addtocart);
                                i--;
                            }
                        }
                    });
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        };
        recyclerview.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();  return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
