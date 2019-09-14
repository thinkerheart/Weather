package com.thinkzi.weather.domain.entity;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class WeatherInformation {

    private DateTime _dateTime;
    private Temperature _temperature;
    private List<WeatherCondition> _weatherConditionList;
    private Cloud _cloud;
    private Wind _wind;
    private Snow _snow;
    private Rain _rain;
    private Humidity _humidity;
    private Pressure _pressure;

    public WeatherInformation() {
        this._dateTime = DateTime.now();
        this._temperature = new Temperature();
        this._weatherConditionList = new ArrayList<>();
        this._cloud = new Cloud();
        this._wind = new Wind();
        this._snow = new Snow();
        this._rain = new Rain();
        this._humidity = new Humidity();
        this._pressure = new Pressure();
    }

    public DateTime getDateTime() {
        return _dateTime;
    }

    public void setDateTime(DateTime _dateTime) {
        this._dateTime = _dateTime;
    }

    public Temperature getTemperature() {
        return _temperature;
    }

    public void setTemperature(Temperature _temperature) {
        this._temperature = _temperature;
    }

    public List<WeatherCondition> getWeatherConditionInformationList() {
        return _weatherConditionList;
    }

    public void setWeatherConditionInformationList(List<WeatherCondition> _weatherConditionList) {
        this._weatherConditionList = _weatherConditionList;
    }

    public Cloud getCloud() {
        return _cloud;
    }

    public void setCloud(Cloud _cloud) {
        this._cloud = _cloud;
    }

    public Wind getWind() {
        return _wind;
    }

    public void setWind(Wind _wind) {
        this._wind = _wind;
    }

    public Snow getSnow() {
        return _snow;
    }

    public void setSnow(Snow _snow) {
        this._snow = _snow;
    }

    public Rain getRain() {
        return _rain;
    }

    public void setRain(Rain _rain) {
        this._rain = _rain;
    }

    public Humidity getHumidity() {
        return _humidity;
    }

    public void setHumidity(Humidity _humidity) {
        this._humidity = _humidity;
    }

    public Pressure getPressure() {
        return _pressure;
    }

    public void setPressure(Pressure _pressure) {
        this._pressure = _pressure;
    }
}
