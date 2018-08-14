package com.example.salmanma.icecreamsatease;
/**
 * Created by Salman M.A on 04-08-2017.
 * adapter for cart
 */
import android.support.v7.widget.RecyclerView;
import android.widget.*;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
public class mnadptcart extends RecyclerView.Adapter<mnadptcart.RecyclerViewHolder>
{

    private ArrayList<mcatcart> arrayList=new ArrayList<mcatcart>();
    public mnadptcart(ArrayList<mcatcart> arrayList)
    {
        this.arrayList=arrayList;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.cartmenu,parent,false);
        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        mcatcart mc=arrayList.get(position);
        holder.lay.setBackgroundResource(mc.getBack());
        holder.nam.setText(mc.getName());
        holder.totpri.setText("Total-"+mc.getPrice());
        holder.cartpri.setText("Price-"+mc.getPrice());
        holder.cartdelpri.setText("Delivery-"+mc.getPrice());
        holder.categ.setText("Category-"+mc.getCategory());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        TextView nam,totpri,cartpri,cartdelpri,categ;
        LinearLayout lay;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            lay=(LinearLayout)itemView.findViewById(R.id.lincart);
            nam = (TextView) itemView.findViewById(R.id.nincart);
            totpri=(TextView)itemView.findViewById(R.id.totincart);
            cartpri=(TextView)itemView.findViewById(R.id.totincart);
            cartdelpri=(TextView)itemView.findViewById(R.id.totincart);
            categ=(TextView)itemView.findViewById(R.id.categnam);


        }
    }
}


