package com.example.salmanma.icecreamsatease;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

class OwnIconRendered extends DefaultClusterRenderer<Shop> {

    public OwnIconRendered(Context context, GoogleMap map,
                           ClusterManager<Shop> clusterManager) {
        super(context, map, clusterManager);
    }

    @Override
    protected void onBeforeClusterItemRendered(Shop item, MarkerOptions markerOptions) {
	     int icid;
                switch (item.getRating()) {
                    case "good":
                        icid = R.drawable.good;
                        break;
                    case "verygood":
                        icid = R.drawable.verygood;
                        break;
                    default:
                        icid = R.drawable.good;
                }
        markerOptions.icon(BitmapDescriptorFactory.fromResource(icid));
        markerOptions.snippet(item.getSnippet());
        markerOptions.title(item.getTitle());
        super.onBeforeClusterItemRendered(item, markerOptions);
    }

    @Override
    protected boolean shouldRenderAsCluster(Cluster<Shop> cluster) {
        return cluster.getSize()>1;
    }
}