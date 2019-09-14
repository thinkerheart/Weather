package com.thinkzi.weather.domain.entity;

public class Coordinate {

    private double _latitude;
    private double _longitude;

    public Coordinate() {
        this._latitude = 0.0;
        this._longitude = 0.0;
    }

    public double getLatitude() {
        return _latitude;
    }

    public void setLatitude(double _latitude) {
        this._latitude = _latitude;
    }

    public double getLongitude() {
        return _longitude;
    }

    public void setLongitude(double _longitude) {
        this._longitude = _longitude;
    }
}
