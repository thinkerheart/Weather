package com.thinkzi.weather.domain.entity

import org.joda.time.DateTime

import java.util.ArrayList

class WeatherInformation {

    var dateTime: DateTime = DateTime.now()
    var temperature: Temperature = Temperature()
    var weatherConditionInformationList: ArrayList<WeatherCondition> = ArrayList()
    var cloud: Cloud = Cloud()
    var wind: Wind = Wind()
    var snow: Snow = Snow()
    var rain: Rain = Rain()
    var humidity: Humidity = Humidity()
    var pressure: Pressure = Pressure()

    init {
        this.dateTime = DateTime.now()
        this.temperature = Temperature()
        this.weatherConditionInformationList = ArrayList()
        this.cloud = Cloud()
        this.wind = Wind()
        this.snow = Snow()
        this.rain = Rain()
        this.humidity = Humidity()
        this.pressure = Pressure()
    }
}
