package com.thinkzi.weather.domain.entity;

public class Snow {

    private double _snowVolume;

    public Snow() {
        this._snowVolume = 0.0;
    }

    public double getSnowVolume() {
        return _snowVolume;
    }

    public void setSnowVolume(double _snowVolume) {
        this._snowVolume = _snowVolume;
    }
}
