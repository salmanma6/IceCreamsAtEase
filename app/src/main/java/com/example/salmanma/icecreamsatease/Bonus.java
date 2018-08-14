package com.example.salmanma.icecreamsatease;
//bonus fragment
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Bonus extends Fragment {
    public Bonus() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.cussharebon, container, false);
        ImageView t=(ImageView)rootView.findViewById(R.id.images);
        t.setImageResource(R.drawable.bonus1);
        t.setBackgroundResource(R.color.White);
        TextView textView=(TextView)rootView.findViewById(R.id.textincushare);
        textView.setVisibility(View.GONE);
        TextView textView1=(TextView)rootView.findViewById(R.id.clickback);
        textView1.setVisibility(View.GONE);
        pl.droidsonroids.gif.GifImageView gddd=(pl.droidsonroids.gif.GifImageView)rootView.findViewById(R.id.gifchuserbon);
        gddd.setVisibility(View.GONE);
        return rootView;
    }
}
