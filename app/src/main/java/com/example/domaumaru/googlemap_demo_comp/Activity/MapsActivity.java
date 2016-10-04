package com.example.domaumaru.googlemap_demo_comp.Activity;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewGroupCompat;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.domaumaru.googlemap_demo_comp.Api.api_FourSquare;
import com.example.domaumaru.googlemap_demo_comp.Api.api_Google;
import com.example.domaumaru.googlemap_demo_comp.Class.cs_DialogSearchBy;
import com.example.domaumaru.googlemap_demo_comp.Class.cs_FourSquareExplore;
import com.example.domaumaru.googlemap_demo_comp.Class.cs_FourSquarePlaces;
import com.example.domaumaru.googlemap_demo_comp.Class.cs_GoogleDirectionsData;
import com.example.domaumaru.googlemap_demo_comp.Data.d_FourSquareExplore;
import com.example.domaumaru.googlemap_demo_comp.Data.d_FourSquarePlaces;
import com.example.domaumaru.googlemap_demo_comp.Data.d_GoogleDirections;
import com.example.domaumaru.googlemap_demo_comp.Function.f_FourSquareExploreCall;
import com.example.domaumaru.googlemap_demo_comp.Function.f_PicassoMarker;
import com.example.domaumaru.googlemap_demo_comp.R;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button btnSearch, btnSearhBy;
    EditText edLocation;

    Polyline polyline;
    LatLng myLocation;
    Geocoder geocoder;
    Retrofit radapter;
    LatLng latLng;
    String latLngAcc;
    String query;
    String radius;
    String limit;

    cs_FourSquarePlaces cs4sp = null;
    cs_FourSquareExplore cs4se = null;

    boolean check = false;
    HashMap<Marker, cs_FourSquareExplore> eventMakerMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        geocoder = new Geocoder(this);

        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearhBy = (Button) findViewById(R.id.btnSeachBy);
        edLocation = (EditText) findViewById(R.id.edLocation);

        latLng = new LatLng(10.767210, 106.687738);
        myLocation = latLng;

        latLngAcc = "10000";
        query = "";
        radius = "400";
        limit = "30";
        d_FourSquarePlaces data = new d_FourSquarePlaces(latLng, latLngAcc, query, radius, limit);

        getFourSquarePlaces(data);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.clear();
                String location = edLocation.getText().toString();
                List<Address> lstAddress = null;
                try {
                    lstAddress = geocoder.getFromLocationName(location, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Address address = lstAddress.get(0);
                LatLng addressLocation = new LatLng(address.getLatitude(), address.getLongitude());

                mMap.clear();
                myLocation = addressLocation;
                d_FourSquarePlaces data = new d_FourSquarePlaces(addressLocation, latLngAcc, query, radius, limit);
                getFourSquarePlaces(data);

                mMap.addMarker(new MarkerOptions().position(addressLocation).title("You're here!")).showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(addressLocation, 18.0f));
            }
        });

        btnSearhBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new cs_DialogSearchBy();
                dialogFragment.show(getSupportFragmentManager(), null);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setPadding(0, 140, 0, 0);

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View view = getLayoutInflater().inflate(R.layout.marker_customlayout, null);

                TextView tvName = (TextView) view.findViewById(R.id.tvName);
                TextView tvLocation = (TextView) view.findViewById(R.id.tvLocation);
                ImageView imgView = (ImageView) view.findViewById(R.id.imgViewMarker);

                if (cs4se != null){
                    tvName.setText(cs4se.getResponse().getVenue().getName());
                    tvLocation.setText(cs4se.getResponse().getVenue().getLocation().getAddress());
                }


//                ProgressDialog a = new ProgressDialog(v.getContext());
//                a.show();
//                String title = marker.getTitle();
//                String id = "";
//                for (int i = 0; i < cs4sp.response.venues.size(); i++) {
//                    if (cs4sp.response.venues.get(i).name.equals(title)) {
//                        id = cs4sp.response.venues.get(i).id;
//                        break;
//                    }
//                }
//                d_FourSquareExplore data = new d_FourSquareExplore(id);
//                String url = "https://api.foursquare.com";
//                radapter = new Retrofit.Builder().baseUrl(url)
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                api_FourSquare rest = radapter.create(api_FourSquare.class);
//                Call<cs_FourSquareExplore> call = rest.getExploreInfo(data.id, data.oauth_token, data.version);
                //new f_FourSquareExploreCall(view, marker).execute(call);
                return view;
            }
        });

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                LatLng position = marker.getPosition();
                LatLng destination = new LatLng(position.latitude, position.longitude);
                d_GoogleDirections dataGoogle = new d_GoogleDirections(myLocation, destination);
                if (polyline != null) {
                    polyline.remove();
                }
                getGoogleDirections(dataGoogle);

                String title = marker.getTitle();
                String id = "";
                for (int i = 0; i < cs4sp.response.venues.size(); i++) {
                    if (cs4sp.response.venues.get(i).name.equals(title)) {
                        id = cs4sp.response.venues.get(i).id;
                        break;
                    }
                }
                d_FourSquareExplore data = new d_FourSquareExplore(id);
                getFourSquareExplore(data);
                marker.showInfoWindow();
                return true;
            }
        });
    }

    private List<LatLng> decodePoly(String encoded) {

        List<LatLng> poly = new ArrayList<>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            poly.add(p);
        }

        return poly;
    }

    Callback<cs_FourSquareExplore> cb_4se = new Callback<cs_FourSquareExplore>() {
        @Override
        public void onResponse(Call<cs_FourSquareExplore> call, Response<cs_FourSquareExplore> response) {
            cs4se = response.body();
        }

        @Override
        public void onFailure(Call<cs_FourSquareExplore> call, Throwable t) {
            Log.v("Failed", t.getMessage());
        }
    };

    Callback<cs_FourSquarePlaces> cb_4sp = new Callback<cs_FourSquarePlaces>() {
        @Override
        public void onResponse(Call<cs_FourSquarePlaces> call, Response<cs_FourSquarePlaces> response) {
            cs4sp = response.body();

            if (cs4sp.response.venues.size() > 0) {
                for (int i = 0; i < cs4sp.response.venues.size(); i++) {
                    Double lat = cs4sp.response.venues.get(i).location.lat;
                    Double lng = cs4sp.response.venues.get(i).location.lng;
                    LatLng latlng = new LatLng(lat, lng);

                    if (cs4sp.response.venues.get(i).categories.size() != 0) {
                        String prefix = cs4sp.response.venues.get(i).categories.get(0).icon.prefix;
                        String suffix = cs4sp.response.venues.get(i).categories.get(0).icon.suffix;
                        boolean bg = true;

                        String iconUrl = getIconUrl(prefix, suffix, bg);

                        Marker myMarker = mMap.addMarker(new MarkerOptions().position(latlng).title(cs4sp.response.venues.get(i).name));
                        f_PicassoMarker marker = new f_PicassoMarker(myMarker);
                        Picasso.with(getBaseContext()).load(iconUrl).into(marker);
                    } else {
                        mMap.addMarker(new MarkerOptions().position(latlng).title(cs4sp.response.venues.get(i).name));
                    }

                }
            }

            Log.v("FourSquare", "Done");
        }

        @Override
        public void onFailure(Call<cs_FourSquarePlaces> call, Throwable t) {
            Log.v("FourSquare", t.getMessage());
        }
    };

    Callback<cs_GoogleDirectionsData> cs_gg = new Callback<cs_GoogleDirectionsData>() {
        @Override
        public void onResponse(Call<cs_GoogleDirectionsData> call, Response<cs_GoogleDirectionsData> response) {
            cs_GoogleDirectionsData data = response.body();
            String points = data.Routes.get(0).OverviewPolyline.Points;
            List<LatLng> list = decodePoly(points);
            PolylineOptions options = new PolylineOptions().width(10).color(Color.parseColor("#00b3fd")).geodesic(true);
            for (int i = 0; i < list.size(); i++) {
                LatLng point = list.get(i);
                options.add(point);
            }
            polyline = mMap.addPolyline(options);

            String travel = "Travel Mode: Driving";
            String duration = "Duration: " + data.Routes.get(0).Legs.get(0).Duration.Text;
            String distance = "Distance: " + data.Routes.get(0).Legs.get(0).Distance.Text;

            displayLayoutInformation(travel, duration, distance);
            Log.v("Success", "Done");
        }

        @Override
        public void onFailure(Call<cs_GoogleDirectionsData> call, Throwable t) {
            Log.v("Failed", t.getMessage());
        }
    };

    private void getFourSquarePlaces(d_FourSquarePlaces data) {
        String url = "https://api.foursquare.com";
        radapter = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api_FourSquare rest = radapter.create(api_FourSquare.class);
        String latLng = data.latLng.latitude + "," + data.latLng.longitude;
        Call<cs_FourSquarePlaces> call = rest.getInfo(data.id, data.secret, data.version,
                latLng, data.latLngAcc, data.query, data.radius, data.limit);
        call.enqueue(cb_4sp);
    }

    private void getFourSquareExplore(d_FourSquareExplore data) {
        try {
            String url = "https://api.foursquare.com";
            radapter = new Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            api_FourSquare rest = radapter.create(api_FourSquare.class);
            Call<cs_FourSquareExplore> call = rest.getExploreInfo(data.id, data.oauth_token, data.version);
            call.enqueue(cb_4se);
        } catch (Exception e) {
            e.printStackTrace();
            Log.v("Failed", e.getMessage());
        }
    }

    private void getGoogleDirections(d_GoogleDirections data) {
        String url = "https://maps.googleapis.com";
        radapter = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api_Google rest = radapter.create(api_Google.class);
        String latLngOrigin = data.origin.latitude + "," + data.origin.longitude;
        String latLngDestination = data.destination.latitude + "," + data.destination.longitude;
        Call<cs_GoogleDirectionsData> call = rest.getDirections(latLngOrigin, latLngDestination, data.key);
        call.enqueue(cs_gg);
    }

    private void displayLayoutInformation(String travel, String duration, String distance) {
        try {
            TextView tvTravel = (TextView) findViewById(R.id.tvTravel);
            TextView tvDistance = (TextView) findViewById(R.id.tvDistance);
            TextView tvDuration = (TextView) findViewById(R.id.tvDuration);
            View v = findViewById(R.id.layoutDriveInformation);

            tvTravel.setText(travel);
            tvDistance.setText(duration);
            tvDuration.setText(distance);

            v.setVisibility(View.VISIBLE);

            Log.v("Success", "Done");
        } catch (Exception e) {
            Log.v("Failed", e.getMessage());
        }
    }

    public void onUserSelectValue(String selectedValue) {
        query = selectedValue;
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(myLocation).title("You are Here!"));
        d_FourSquarePlaces data = new d_FourSquarePlaces(myLocation, latLngAcc, query, radius, limit);
        getFourSquarePlaces(data);
    }

    private String getIconUrl(String prefix, String suffix, boolean bg) {
        //32, 44, 64, 88
        try {
            String size = "32";
            String sBg = "bg_";
            String result;
            if (bg) {
                result = prefix + sBg + size + suffix;
            } else {
                result = prefix + size + suffix;
            }
            return result;
        } catch (Exception e) {
            Log.v("Failed", e.getMessage());
            return "";
        }
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
}
