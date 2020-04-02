package com.timkontrakan.infocoronavirus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Provinsi{

    private String Provinsi;
    private String Kasus_Posi;
    private String Kasus_Semb;
    private String Kasus_Meni;

    public Provinsi() {
    }

    public Provinsi(String provinsi, String kasus_Posi, String kasus_Semb, String kasus_Meni) {
        Provinsi = provinsi;
        Kasus_Posi = kasus_Posi;
        Kasus_Semb = kasus_Semb;
        Kasus_Meni = kasus_Meni;
    }

    public String getProvinsi() {
        return Provinsi;
    }

    public void setProvinsi(String provinsi) {
        Provinsi = provinsi;
    }

    public String getKasus_Posi() {
        return Kasus_Posi;
    }

    public void setKasus_Posi(String kasus_Posi) {
        Kasus_Posi = kasus_Posi;
    }

    public String getKasus_Semb() {
        return Kasus_Semb;
    }

    public void setKasus_Semb(String kasus_Semb) {
        Kasus_Semb = kasus_Semb;
    }

    public String getKasus_Meni() {
        return Kasus_Meni;
    }

    public void setKasus_Meni(String kasus_Meni) {
        Kasus_Meni = kasus_Meni;
    }
}
