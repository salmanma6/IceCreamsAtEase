


package com.example.salmanma.icecreamsatease;
/**
 * Created by Salman M.A on 04-08-2017.
 * adapter for main menu
 */
import android.app.Activity;
import android.app.Application;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.widget.*;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.view.View.*;

public class mnadpt extends RecyclerView.Adapter<mnadpt.RecyclerViewHolder>
{
    private Context e;
    private Uri myuri;
    private ArrayList<mcat> arrayList=new ArrayList<mcat>();
    StorageReference storageRef,pathref;
    public mnadpt(ArrayList<mcat> arrayList,Context context)
    {    e=context;
        this.arrayList=arrayList;
        storageRef=FirebaseStorage.getInstance().getReference();
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.menu,parent,false);
        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        mcat mc=arrayList.get(position);
        pathref=storageRef.child(mc.getImgid());
        Glide.with(e).using(new FirebaseImageLoader()).load(pathref).placeholder(R.drawable.defmen).into(holder.img);
        holder.nam.setText(mc.getName());
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView nam;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            img=(ImageView) itemView.findViewById(R.id.mmenim);
            nam = (TextView) itemView.findViewById(R.id.mmennam);
        }
    }
}


