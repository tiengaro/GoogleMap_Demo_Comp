package com.example.domaumaru.googlemap_demo_comp.Function;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.domaumaru.googlemap_demo_comp.Class.cs_FourSquareExplore;
import com.example.domaumaru.googlemap_demo_comp.R;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Doma Umaru on 10/3/2016.
 */

public class f_FourSquareExploreCall extends AsyncTask<Call, Void, cs_FourSquareExplore>{

    private View view;
    private Marker mSelectedMarker;

    public f_FourSquareExploreCall(final View view, Marker mSelectedMarker){
        this.view = view;
        this.mSelectedMarker = mSelectedMarker;
    }

    @Override
    protected cs_FourSquareExplore doInBackground(Call... params) {
        cs_FourSquareExplore result = new cs_FourSquareExplore();
        try{
            Call<cs_FourSquareExplore> call = params[0];
            Response<cs_FourSquareExplore> response = call.execute();
            result = response.body();
        }catch (IOException e){
            e.printStackTrace();
            Log.v("Failed", e.getMessage());
        }
        return result;
    }

    @Override
    protected final void onPostExecute(final cs_FourSquareExplore cs4se){
        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextView tvLocation = (TextView) view.findViewById(R.id.tvLocation);
        ImageView imgView = (ImageView) view.findViewById(R.id.imgViewMarker);
        if (cs4se.getResponse() != null){
            String address = cs4se.getResponse().getVenue().getLocation().getAddress();
            String prefix = cs4se.getResponse().getVenue().getBestPhoto().getPrefix();
            String suffix = cs4se.getResponse().getVenue().getBestPhoto().getSuffix();
            String imageUrl = getImageUrl(prefix, suffix);
            tvName.setText(cs4se.getResponse().getVenue().getName());
            tvLocation.setText(address);
            Picasso.with(view.getContext()).load(imageUrl).into(imgView);
        }
        refreshInfoWindow();
    }

    private String getImageUrl(String prefix, String suffix) {
        try {
            String size = "50x50";
            String result = prefix + size + suffix;
            return result;
        } catch (Exception e) {
            Log.v("Failed", e.getMessage());
            return "";
        }
    }

    private void refreshInfoWindow(){
        if (mSelectedMarker == null){
            return;
        }else{
            mSelectedMarker.showInfoWindow();
        }
    }
}
