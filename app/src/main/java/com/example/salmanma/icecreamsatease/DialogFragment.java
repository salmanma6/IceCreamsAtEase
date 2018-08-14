package com.example.salmanma.icecreamsatease;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;

public class DialogFragment extends BottomSheetDialogFragment {
    RecyclerView recyclerView;
    MarkerBottomAdapter markerBottomAdapter;
    private BottomSheetBehavior.BottomSheetCallback mBottomSheetBehaviorCallback = new BottomSheetBehavior.BottomSheetCallback() {

        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                bottomSheet.setMinimumHeight(500);
            }


        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            bottomSheet.setMinimumHeight(500);
        }

    };
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.fragment_bottom_sheet, null);
        dialog.setContentView(contentView);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();
        CoordinatorLayout.Behavior behavior = params.getBehavior();

        if( behavior != null && behavior instanceof BottomSheetBehavior) {
            ((BottomSheetBehavior) behavior).setBottomSheetCallback(mBottomSheetBehaviorCallback);
        }
        final BottomSheetBehavior mBehavior = BottomSheetBehavior.from((View)contentView.getParent());
        mBehavior.setPeekHeight(500);
        recyclerView=(RecyclerView)contentView.findViewById(R.id.recyclerviewinbtm);
        markerBottomAdapter =new MarkerBottomAdapter(mainicemap.sjops,getContext());
        recyclerView.setAdapter(markerBottomAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        dismiss();
                        Shop sns=mainicemap.sjops.get(position);
                        mainicemap.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sns.latLng,15));
                        mainicemap.mMap.animateCamera(CameraUpdateFactory.zoomTo(19),2500,null);
                    }
                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
     }

}
