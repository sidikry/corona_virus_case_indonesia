package com.timkontrakan.infocoronavirus.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Corona {

    private String name;
    private String positif;
    private String sembuh;
    private String meninggal;

    public String getName() {
        return name;
    }

    public String getPositif() {
        return positif;
    }

    public String getSembuh() {
        return sembuh;
    }

    public String getMeninggal() {
        return meninggal;
    }
}
