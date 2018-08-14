package com.example.salmanma.icecreamsatease;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class settingshop extends AppCompatActivity {
private ArrayList<String> hello=new ArrayList<>();
public static ArrayList<mcat> a=new ArrayList<>();
    int i=0;
public static Map<Integer,Class> hc=new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comingback);
        TextView t=(TextView)findViewById(R.id.gncm);
        t.setText("On the way...");
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference().child("products").child("type");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dt:dataSnapshot.getChildren())
                {
                    hello.add(dt.getKey());
                }
				try{
                    if (hello.contains("specialicecreams")) {
                        i++;
                        hc.put(i,spice.class);
                        a.add(new mcat("Special icecreams", "specialice.jpg"));
                    }
                    if (hello.contains("icecreamcakes"))
                     {   i++;
                         hc.put(i,icecake.class);
                         a.add(new mcat("Icecream Cakes", "icecreamcake.jpg"));
                     }
                    if(hello.contains("familypacks")) {
                        i++;
                        hc.put(i,Fampack.class);
                        a.add(new mcat("Family Packs", "familypack.jpg"));
                    }
                    if(hello.contains("cones")) {
                        i++;
                        hc.put(i,Cones.class);
                        a.add(new mcat("Cones", "cone.jpg"));
                    }
                    if(hello.contains("cups")) {
                        i++;
                        hc.put(i,Cups.class);
                        a.add(new mcat("Cups", "cups.jpg"));
                    }
                    if(hello.contains("bars")) {
                        i++;
                        hc.put(i,Bars.class);
                        a.add(new mcat("Bars", "bar.jpg"));
                    }
                    if(hello.contains("tubs")) {
                        i++;
                        hc.put(i,Tubs.class);
                        a.add(new mcat("Tubs", "tubs.jpg"));
                    }if(hello.contains("floats")) {
                        i++;
                        hc.put(i,Floats.class);
                        a.add(new mcat("Floats", "floats.jpg"));
                    }
                    if(hello.contains("icecreamshakes")) {
                        i++;
                        hc.put(i,iceshakes.class);
                        a.add(new mcat("Icecream Shakes", "shake.jpg"));
                    }if(hello.contains("extras"))
                    {
                        i++;
                        hc.put(i,Extras.class);
                        a.add(new mcat("Extras","extras.png"));
                }}
				catch(Exception e)
			    {
					e.printStackTrace();
				}	
                
                nextgo();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Error 404",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void nextgo()
    {
        Runnable r = new Runnable() {
            @Override
            public void run(){
                startActivity(new Intent(settingshop.this,MainActivity.class));
            }
        };
        Handler h = new Handler();
        h.postDelayed(r, 3500);
    }
}
