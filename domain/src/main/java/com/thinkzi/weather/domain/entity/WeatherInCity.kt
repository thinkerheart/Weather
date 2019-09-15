package com.thinkzi.weather.domain.entity

import java.util.ArrayList

class WeatherInCity {

    var weatherInformationList: ArrayList<WeatherInformation> = ArrayList()
    var city: City = City()

    init {
        this.weatherInformationList = ArrayList()
        this.city = City()
    }
}
