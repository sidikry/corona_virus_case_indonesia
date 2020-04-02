package com.timkontrakan.infocoronavirus.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.timkontrakan.infocoronavirus.R;
import com.timkontrakan.infocoronavirus.adapter.ProvAdapter;
import com.timkontrakan.infocoronavirus.api.API;
import com.timkontrakan.infocoronavirus.api.IRetrofit;
import com.timkontrakan.infocoronavirus.api.RetrofitClient;
import com.timkontrakan.infocoronavirus.model.Provinsi;
import com.timkontrakan.infocoronavirus.model.ProvinsiResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailProvinsiActivity extends AppCompatActivity {

    private RecyclerView rvProvinsi;
    private ProvAdapter provAdapter;
    private List<Provinsi> provinsiList;
    private IRetrofit iRetrofit;
    String TAG = "TEST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_provinsi);
        rvProvinsi = findViewById(R.id.rv_provinsi);
        rvProvinsi.setLayoutManager(new LinearLayoutManager(this));
        provinsiList = new ArrayList<>();
        getProvinsi();
    }

    private void getProvinsi() {
        iRetrofit = RetrofitClient.getClient(API.url).create(IRetrofit.class);
        iRetrofit.getProvinsi().enqueue(new Callback<List<ProvinsiResponse>>() {
            @Override
            public void onResponse(Call<List<ProvinsiResponse>> call, Response<List<ProvinsiResponse>> response) {
                rvProvinsi.setAdapter(new ProvAdapter(DetailProvinsiActivity.this, response.body()));
            }

            @Override
            public void onFailure(Call<List<ProvinsiResponse>> call, Throwable t) {
                Toast.makeText(DetailProvinsiActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
