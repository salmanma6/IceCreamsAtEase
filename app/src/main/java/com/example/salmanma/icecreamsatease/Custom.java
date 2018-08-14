package com.example.salmanma.icecreamsatease;
//fragment for custom icecreams
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


public class Custom extends Fragment {
    public Custom() {
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
        TextView textView1=(TextView)rootView.findViewById(R.id.clickback);
        textView1.setVisibility(View.GONE);
        ImageView t=(ImageView)rootView.findViewById(R.id.images);
        t.setImageResource(R.drawable.custom1);
        t.setBackgroundResource(R.color.black);
        TextView textView=(TextView)rootView.findViewById(R.id.textincushare);
        textView.setVisibility(View.GONE);
        pl.droidsonroids.gif.GifImageView gddd=(pl.droidsonroids.gif.GifImageView)rootView.findViewById(R.id.gifchuserbon);
        gddd.setVisibility(View.GONE);
        return rootView;

    }
}
