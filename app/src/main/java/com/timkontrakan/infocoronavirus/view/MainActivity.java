package com.timkontrakan.infocoronavirus.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.timkontrakan.infocoronavirus.R;
import com.timkontrakan.infocoronavirus.api.API;
import com.timkontrakan.infocoronavirus.api.IRetrofit;
import com.timkontrakan.infocoronavirus.api.RetrofitClient;
import com.timkontrakan.infocoronavirus.model.Corona;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tvPositif, tvSembuh, tvMeninggal, tvSee_all;
    private IRetrofit iRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPositif = findViewById(R.id.total_positif);
        tvSembuh = findViewById(R.id.total_sembuh);
        tvMeninggal = findViewById(R.id.total_meninggal);
        tvSee_all = findViewById(R.id.see_all);
        getData();
        moveActivity();

    }

    private void getData(){
        iRetrofit = RetrofitClient.getClient(API.url).create(IRetrofit.class);
        iRetrofit.getData().enqueue(new Callback<List<Corona>>() {
            @Override
            public void onResponse(Call<List<Corona>> call, Response<List<Corona>> response) {
                tvPositif.setText(response.body().get(0).getPositif() + " Orang");
                tvMeninggal.setText(response.body().get(0).getMeninggal() + " Orang");
                tvSembuh.setText(response.body().get(0).getSembuh() + " Orang");
            }

            @Override
            public void onFailure(Call<List<Corona>> call, Throwable t) {

            }
        });
    }

    private void moveActivity(){
        tvSee_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailProvinsiActivity.class);
                startActivity(intent);
            }
        });
    }
}
