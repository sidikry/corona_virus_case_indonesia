package com.timkontrakan.infocoronavirus.api;

import com.timkontrakan.infocoronavirus.model.Corona;
import com.timkontrakan.infocoronavirus.model.ProvinsiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IRetrofit {

    @GET("indonesia")
    Call<List<Corona>> getData();

    @GET("indonesia/provinsi")
    Call<List<ProvinsiResponse>> getProvinsi();
}
