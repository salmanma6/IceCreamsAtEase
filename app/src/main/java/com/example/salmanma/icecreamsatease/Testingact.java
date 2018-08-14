package com.example.salmanma.icecreamsatease;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Testingact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testingact);
        final ImageView img=(ImageView)findViewById(R.id.imagefortest);
     DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("products").child("type").child("Newlaunch").child("Choco crackle");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mcatnew a=dataSnapshot.getValue(mcatnew.class);
                String s=a.link;
                if(s==null)
                {
                    tell();
                    return;
                }
                Uri uri=Uri.parse(s);
                Glide.with(getApplicationContext()).load(uri).into(img);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
    public void tell()
    {
        Toast.makeText(getApplicationContext(),"Oops ",Toast.LENGTH_LONG).show();
    }
}
