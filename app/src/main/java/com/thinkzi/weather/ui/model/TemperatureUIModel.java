package com.thinkzi.weather.ui.model;

public class TemperatureUIModel {

    private double _temperature;
    private double _minTemperature;
    private double _maxTemperature;

    public TemperatureUIModel() {
        this._temperature = 0.0;
        this._minTemperature = 0.0;
        this._maxTemperature = 0.0;
    }

    public double getMinTemperature() {
        return _minTemperature;
    }

    public void setMinTemperature(double _minTemperature) {
        this._minTemperature = _minTemperature;
    }

    public double getMaxTemperature() {
        return _maxTemperature;
    }

    public void setMaxTemperature(double _maxTemperature) {
        this._maxTemperature = _maxTemperature;
    }

    public double getTemperature() {
        return _temperature;
    }

    public void setTemperature(double _dayTemperature) {
        this._temperature = _dayTemperature;
    }

}
