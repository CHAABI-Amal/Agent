package com.example.agent.retrofit;


import com.example.agent.models.Machine;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MachineApi {

    @GET("/amal/machines")
    Call<List<Machine>> getMachines();

    @POST("/amal/machines")
    Call<Machine> addmachine(@Body Machine machine);


}
