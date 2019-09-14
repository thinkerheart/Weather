package com.thinkzi.weather.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class WeatherInCity {

    private List<WeatherInformation> _weatherInformationList;
    private City _city;

    public WeatherInCity() {
        this._weatherInformationList = new ArrayList<>();
        this._city = new City();
    }

    public List<WeatherInformation> getWeatherInformationList() {
        return _weatherInformationList;
    }

    public void setWeatherInformationList(List<WeatherInformation> _weatherInformationList) {
        this._weatherInformationList = _weatherInformationList;
    }

    public City getCity() {
        return _city;
    }

    public void setCity(City _city) {
        this._city = _city;
    }
}
