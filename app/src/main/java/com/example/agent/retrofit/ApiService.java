package com.example.agent.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("getTopic")
    Call<String> getTopic();
}
