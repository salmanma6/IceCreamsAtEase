


package com.example.salmanma.icecreamsatease;
/**
 * Created by Salman M.A on 04-08-2017.
 * adapter for favourites
 *
import android.support.v7.widget.RecyclerView;
import android.widget.*;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
public class mnadptfav extends RecyclerView.Adapter<mnadptfav.RecyclerViewHolder>
{

    private ArrayList<mcatnew> arrayList=new ArrayList<mcatnew>();
    public mnadptfav(ArrayList<mcatnew> arrayList)
    {
        this.arrayList=arrayList;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.favmenu,parent,false);
        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        mcatnew mc=arrayList.get(position);
        //holder.img.setImageResource(mc.getImgid());
      //  holder.lay.setBackgroundResource(mc.getBack());
        holder.nam.setText(mc.getName());
        holder.cat.setText("Category:"+mc.getCategory());
        holder.pri.setText(mc.getPrice());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView nam,cat,pri;
        LinearLayout lay;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            lay=(LinearLayout)itemView.findViewById(R.id.linfav);
            img=(ImageView) itemView.findViewById(R.id.favpic);
            nam = (TextView) itemView.findViewById(R.id.favname);
            cat=(TextView)itemView.findViewById(R.id.favcateg);
            pri=(TextView)itemView.findViewById(R.id.favprice);
        }
    }
}


*/