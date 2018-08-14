


package com.example.salmanma.icecreamsatease;
/**
 * Created by Salman M.A on 04-08-2017.
 * adapter for recent orders
 *
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.widget.*;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
public class mnadptrecent extends RecyclerView.Adapter<mnadptrecent.RecyclerViewHolder>
{

    private ArrayList<mcatrecent> arrayList=new ArrayList<mcatrecent>();
    public mnadptrecent(ArrayList<mcatrecent> arrayList)
    {
        this.arrayList=arrayList;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.recentordermenu,parent,false);
        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        mcatrecent mc=arrayList.get(position);
        holder.lay.setBackgroundResource(mc.getBack());
        holder.img.setImageResource(mc.getImgid());
        if(mc.isDelivered()==true)
            holder.chk.setImageResource(R.drawable.check);
        else
            holder.chk.setImageResource(R.drawable.orderuncheck);
        holder.nam.setText(mc.getName());
        holder.cat.setText("Category:"+mc.getCategory());
        holder.pri.setText("Price-"+mc.getPrice());
        holder.del.setText("Delivery-"+mc.getDelivery());
        holder.tot.setText("Total-"+mc.getTotal());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img,chk;
        TextView nam,cat,pri,del,tot,shp;
        LinearLayout lay;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            lay=(LinearLayout)itemView.findViewById(R.id.linrec);
            img=(ImageView) itemView.findViewById(R.id.recpic);
            chk=(ImageView) itemView.findViewById(R.id.ordercheck);
            nam = (TextView) itemView.findViewById(R.id.recname);
            cat=(TextView)itemView.findViewById(R.id.reccateg);
            pri=(TextView)itemView.findViewById(R.id.recprice);
            del=(TextView)itemView.findViewById(R.id.recdel);
            tot=(TextView)itemView.findViewById(R.id.rectot);
        }
    }
}


*/