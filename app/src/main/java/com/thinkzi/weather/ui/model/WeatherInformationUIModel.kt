package com.thinkzi.weather.ui.model

import org.joda.time.DateTime

import java.util.ArrayList

class WeatherInformationUIModel {

    var dateTime: DateTime = DateTime.now()
    var temperature: TemperatureUIModel = TemperatureUIModel()
    var weatherConditionInformationList: ArrayList<WeatherConditionUIModel> = ArrayList()
    var cloud: CloudUIModel = CloudUIModel()
    var wind: WindUIModel = WindUIModel()
    var snow: SnowUIModel = SnowUIModel()
    var rain: RainUIModel = RainUIModel()
    var humidity: HumidityUIModel = HumidityUIModel()
    var pressure: PressureUIModel = PressureUIModel()

    init {
        this.dateTime = DateTime.now()
        this.temperature = TemperatureUIModel()
        this.weatherConditionInformationList = ArrayList()
        this.cloud = CloudUIModel()
        this.wind = WindUIModel()
        this.snow = SnowUIModel()
        this.rain = RainUIModel()
        this.humidity = HumidityUIModel()
        this.pressure = PressureUIModel()
    }
}
