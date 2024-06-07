package com.example.agent.retrofit;
import com.example.agent.models.Composant;

import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
public interface ComposantApi {

    @GET("/amal/composants/{id}/value/{valueComposant}")
    Call<String> findByIdCheckaddInfo(@Path("id") UUID composantId, @Path("valueComposant") float value);

    @GET("/amal/composants")
    Call<List<Composant>> getComposant();
    @POST("/amal/composants")
    Call<Composant> addcomposant(@Body Composant composant);


    @PATCH("/amal/composants/{id}/value")
    Call<String> findByIdValue(@Path("id") UUID composantId, @Body Composant composant);

}
