package com.thinkzi.weather.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rain {

    @SerializedName("rainVolume")
    @Expose
    private double rainVolume;

    public Rain() {
        this.rainVolume = 0.0;
    }

    public double getRainVolume() {
        return rainVolume;
    }

    public void setRainVolume(double _rainVolume) {
        this.rainVolume = rainVolume;
    }

}
