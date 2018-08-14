
package com.example.salmanma.icecreamsatease;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//adapter for new launches
public class mnadptnew extends RecyclerView.ViewHolder
{
    View vview;
    public TextView pnam,pcateg,pprice;
    public ImageView ppic,cartclik,loveclik;
    public LinearLayout linearlayout;
    int i=0;
    Context context;
    public mnadptnew(View itemView) {
        super(itemView);
        vview=itemView;
        pnam=(TextView)itemView.findViewById(R.id.newname);
        pcateg=(TextView)itemView.findViewById(R.id.newcateg);
        pprice=(TextView)itemView.findViewById(R.id.newprice);
        ppic=(ImageView)itemView.findViewById(R.id.newpic);
        linearlayout=(LinearLayout)itemView.findViewById(R.id.linnew);
        cartclik=(ImageView)itemView.findViewById(R.id.cartclick);
        loveclik=(ImageView)itemView.findViewById(R.id.loveclick);
    }

}


