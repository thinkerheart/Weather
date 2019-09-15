package com.thinkzi.weather.ui.model

import java.util.ArrayList

class WeatherInCityUIModel {

    var weatherInformationList: ArrayList<WeatherInformationUIModel> = ArrayList()
    var city: CityUIModel = CityUIModel()

    init {
        this.weatherInformationList = ArrayList()
        this.city = CityUIModel()
    }
}
