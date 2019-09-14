package com.thinkzi.weather.ui.model;

public class CloudUIModel {

    private int _cloudiness;

    public CloudUIModel() {
        this._cloudiness = 0;
    }

    public int getCloudiness() {
        return _cloudiness;
    }

    public void setCloudiness(int _cloudiness) {
        this._cloudiness = _cloudiness;
    }
}
