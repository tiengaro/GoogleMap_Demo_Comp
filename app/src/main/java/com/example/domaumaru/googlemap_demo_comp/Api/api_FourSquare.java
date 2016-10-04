package com.example.domaumaru.googlemap_demo_comp.Api;

import com.example.domaumaru.googlemap_demo_comp.Class.cs_FourSquareExplore;
import com.example.domaumaru.googlemap_demo_comp.Class.cs_FourSquarePlaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Doma Umaru on 9/27/2016.
 */

public interface api_FourSquare {
    @GET("/v2/venues/search")
    Call<cs_FourSquarePlaces> getInfo (@Query("client_id") String id,
                                       @Query("client_secret") String secret,
                                       @Query("v") String version,
                                       @Query("ll") String latLng,
                                       @Query("llAcc") String latLngAcc,
                                       @Query("query") String query,
                                       @Query("radius") String radius,
                                       @Query("limit") String limit);

    @GET("/v2/venues/{id}")
    Call<cs_FourSquareExplore> getExploreInfo (@Path("id") String id,
                                               @Query("oauth_token") String token,
                                               @Query("v") String v);

}
