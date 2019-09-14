package com.thinkzi.weather.domain.entity;

public class Cloud {

    private int _cloudiness;

    public Cloud() {
        this._cloudiness = 0;
    }

    public int getCloudiness() {
        return _cloudiness;
    }

    public void setCloudiness(int _cloudiness) {
        this._cloudiness = _cloudiness;
    }
}
