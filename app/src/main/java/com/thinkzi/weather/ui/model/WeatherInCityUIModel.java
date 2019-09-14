package com.thinkzi.weather.ui.model;

import java.util.ArrayList;
import java.util.List;

public class WeatherInCityUIModel {

    private List<WeatherInformationUIModel> _weatherInformationUIModelList;
    private CityUIModel _cityUIModel;

    public WeatherInCityUIModel() {
        this._weatherInformationUIModelList = new ArrayList<>();
        this._cityUIModel = new CityUIModel();
    }

    public List<WeatherInformationUIModel> getWeatherInformationList() {
        return _weatherInformationUIModelList;
    }

    public void setWeatherInformationList(List<WeatherInformationUIModel> _weatherInformationUIModelList) {
        this._weatherInformationUIModelList = _weatherInformationUIModelList;
    }

    public CityUIModel getCity() {
        return _cityUIModel;
    }

    public void setCity(CityUIModel _cityUIModel) {
        this._cityUIModel = _cityUIModel;
    }
}
