package com.timkontrakan.infocoronavirus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.timkontrakan.infocoronavirus.R;
import com.timkontrakan.infocoronavirus.model.Provinsi;
import com.timkontrakan.infocoronavirus.model.ProvinsiResponse;

import java.util.List;

public class ProvAdapter extends RecyclerView.Adapter<ProvAdapter.viewHolder> {

    Context context;
    List<ProvinsiResponse> provinsiList;

    public ProvAdapter(Context context, List<ProvinsiResponse> provinsiList) {
        this.context = context;
        this.provinsiList = provinsiList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_provinsi, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Provinsi attributes = provinsiList.get(position).getAttributes();
        holder.tvPositif.setText(attributes.getKasus_Posi());
        holder.tvSembuh.setText(attributes.getKasus_Semb());
        holder.tvMeninggal.setText(attributes.getKasus_Meni());
        holder.tvProvinsi.setText(attributes.getProvinsi());
    }

    @Override
    public int getItemCount() {
        return provinsiList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

         TextView tvProvinsi;
         TextView tvSembuh;
         TextView tvPositif;
         TextView tvMeninggal;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            tvProvinsi = itemView.findViewById(R.id.provinsi);
            tvSembuh = itemView.findViewById(R.id.kasus_sembuh);
            tvPositif = itemView.findViewById(R.id.kasus_positif);
            tvMeninggal = itemView.findViewById(R.id.kasus_meninggal);
        }
    }
}

