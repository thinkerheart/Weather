package com.thinkzi.weather.ui.model;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class WeatherInformationUIModel {

    private DateTime _dateTime;
    private TemperatureUIModel _temperatureUIModel;
    private List<WeatherConditionUIModel> _weatherConditionUIModelList;
    private CloudUIModel _cloudUIModel;
    private WindUIModel _windUIModel;
    private SnowUIModel _snowUIModel;
    private RainUIModel _rainUIModel;
    private HumidityUIModel _humidityUIModel;
    private PressureUIModel _pressureUIModel;

    public WeatherInformationUIModel() {
        this._dateTime = DateTime.now();
        this._temperatureUIModel = new TemperatureUIModel();
        this._weatherConditionUIModelList = new ArrayList<>();
        this._cloudUIModel = new CloudUIModel();
        this._windUIModel = new WindUIModel();
        this._snowUIModel = new SnowUIModel();
        this._rainUIModel = new RainUIModel();
        this._humidityUIModel = new HumidityUIModel();
        this._pressureUIModel = new PressureUIModel();
    }

    public DateTime getDateTime() {
        return _dateTime;
    }

    public void setDateTime(DateTime _dateTime) {
        this._dateTime = _dateTime;
    }

    public TemperatureUIModel getTemperature() {
        return _temperatureUIModel;
    }

    public void setTemperature(TemperatureUIModel _temperatureUIModel) {
        this._temperatureUIModel = _temperatureUIModel;
    }

    public List<WeatherConditionUIModel> getWeatherConditionInformationList() {
        return _weatherConditionUIModelList;
    }

    public void setWeatherConditionInformationList(List<WeatherConditionUIModel> _weatherConditionUIModelList) {
        this._weatherConditionUIModelList = _weatherConditionUIModelList;
    }

    public CloudUIModel getCloud() {
        return _cloudUIModel;
    }

    public void setCloud(CloudUIModel _cloudUIModel) {
        this._cloudUIModel = _cloudUIModel;
    }

    public WindUIModel getWind() {
        return _windUIModel;
    }

    public void setWind(WindUIModel _windUIModel) {
        this._windUIModel = _windUIModel;
    }

    public SnowUIModel getSnow() {
        return _snowUIModel;
    }

    public void setSnow(SnowUIModel _snowUIModel) {
        this._snowUIModel = _snowUIModel;
    }

    public RainUIModel getRain() {
        return _rainUIModel;
    }

    public void setRain(RainUIModel _rainUIModel) {
        this._rainUIModel = _rainUIModel;
    }

    public HumidityUIModel getHumidity() {
        return _humidityUIModel;
    }

    public void setHumidity(HumidityUIModel _humidityUIModel) {
        this._humidityUIModel = _humidityUIModel;
    }

    public PressureUIModel getPressure() {
        return _pressureUIModel;
    }

    public void setPressure(PressureUIModel _pressureUIModel) {
        this._pressureUIModel = _pressureUIModel;
    }
}
