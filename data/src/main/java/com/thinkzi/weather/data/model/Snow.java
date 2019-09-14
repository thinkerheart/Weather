package com.thinkzi.weather.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Snow {

    @SerializedName("snowVolume")
    @Expose
    private double snowVolume;

    public Snow() {
        this.snowVolume = 0.0;
    }

    public double getSnowVolume() {
        return snowVolume;
    }

    public void setSnowVolume(double _snowVolume) {
        this.snowVolume = snowVolume;
    }
}
