package com.example.salmanma.icecreamsatease;

/**
 * Created by Salman on 25-10-2017.
 */


import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
/**
 * Created by Salman M.A on 04-08-2017.
 * adapter for shop recycler view menu
 */
public class MarkerBottomAdapter extends RecyclerView.Adapter<MarkerBottomAdapter.RecyclerViewHolder>
{
    private Context e;
    private ArrayList<Shop> arrayList=new ArrayList<Shop>();
    public MarkerBottomAdapter(ArrayList<Shop> arrayList,Context context)
    {    e=context;
        this.arrayList=arrayList;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopmapitem,parent,false);
        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Shop mc=arrayList.get(position);
        holder.nam.setText(mc.getName());
        double d=distance(Double.parseDouble(mc.getLat()),Double.parseDouble(mc.getLng()),17.428224,78.442719);
        double fnd = Math.round(d * 100);
        fnd = fnd/100;
        holder.cur.setText(fnd+"km");
        holder.del.setText(fnd+"km");
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        TextView nam,cur,del;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            nam = (TextView)itemView.findViewById(R.id.shpnameinbtm);
            cur = (TextView)itemView.findViewById(R.id.tenene);
            del = (TextView)itemView.findViewById(R.id.tententet);
        }
    }
    private double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1))
                * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}


