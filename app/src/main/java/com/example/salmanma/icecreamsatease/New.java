package com.example.salmanma.icecreamsatease;
//new launches fragment
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.ImageVideoModelLoader;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.*;
public class New extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private DatabaseReference reference;
    int i=0,j=0;
    public New() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.menu_list, container, false);
        recyclerView=(RecyclerView)rootView.findViewById(R.id.mainmenulist);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        TextView aaf=(TextView)rootView.findViewById(R.id.fragnam);
        aaf.setText("New Launches");
        reference=FirebaseDatabase.getInstance().getReference("products").child("type").child("Newlaunch");
        FirebaseRecyclerAdapter<mcatnew,mnadptnew> adapter=new FirebaseRecyclerAdapter<mcatnew, mnadptnew>(mcatnew.class,R.layout.menufornew,mnadptnew.class,reference) {
            @Override
            protected void populateViewHolder(final mnadptnew viewHolder, mcatnew model, int position) {
                try {


                    viewHolder.linearlayout.setBackgroundResource(getResources().getIdentifier(model.getBack(), "color", getActivity().getPackageName()));
                    viewHolder.pnam.setText(model.getName());
                    viewHolder.pcateg.setText(model.getCategory());
                    viewHolder.pprice.setText("Price:"+model.getPrice());
                    Picasso.with(getContext()).setLoggingEnabled(true);
                    Picasso.with(getContext())
                            .load(model.getLink())
                            .placeholder(R.drawable.defice)
                            .into(viewHolder.ppic);
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
                    Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        };
        recyclerView.setAdapter(adapter);
        return rootView;
    }

}
