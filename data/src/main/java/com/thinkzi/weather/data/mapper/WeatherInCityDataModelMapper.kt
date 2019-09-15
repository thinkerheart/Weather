package com.thinkzi.weather.data.mapper

import com.thinkzi.weather.data.model.List
import com.thinkzi.weather.data.model.Result
import com.thinkzi.weather.data.model.Weather
import com.thinkzi.weather.domain.entity.WeatherCondition
import com.thinkzi.weather.domain.entity.WeatherInCity
import com.thinkzi.weather.domain.entity.WeatherInformation

import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.Instant

import java.util.ArrayList

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherInCityDataModelMapper @Inject
constructor() {

    fun transform(_result: Result?): WeatherInCity {

        requireNotNull(_result) { "Cannot transform a null Result" }

        val _weatherInCity = WeatherInCity()

        _weatherInCity.city.id = _result.city.id
        _weatherInCity.city.name = _result.city.name
        _weatherInCity.city.country = _result.city.country
        _weatherInCity.city.coordinate.longitude = _result.city.coord.lon
        _weatherInCity.city.coordinate.latitude = _result.city.coord.lat

        _weatherInCity.weatherInformationList = ArrayList()

        for (_list in _result.list) {

            val _weatherInformation = WeatherInformation()
            _weatherInformation.dateTime =
                DateTime(Instant.ofEpochSecond(_list.dt.toLong()), DateTimeZone.getDefault())
            _weatherInformation.cloud.cloudiness = _list.clouds.all
            _weatherInformation.humidity.humidity = _list.main.humidity
            _weatherInformation.pressure.pressure = _list.main.pressure
            _weatherInformation.rain.rainVolume = _list.rain.rainVolume
            _weatherInformation.snow.snowVolume = _list.snow.snowVolume
            _weatherInformation.wind.speed = _list.wind.speed
            _weatherInformation.wind.direction = _list.wind.deg
            _weatherInformation.temperature.maxTemperature = _list.main.tempMax
            _weatherInformation.temperature.minTemperature = _list.main.tempMin
            _weatherInformation.temperature.temperature = _list.main.temp
            _weatherInformation.weatherConditionInformationList = ArrayList()

            for (_weather in _list.weather) {

                val _weatherCondition = WeatherCondition()
                _weatherCondition.id = _weather.id
                _weatherCondition.condition = _weather.main
                _weatherCondition.description = _weather.description
                _weatherCondition.icon = _weather.icon

                _weatherInformation.weatherConditionInformationList.add(_weatherCondition)

            }

            _weatherInCity.weatherInformationList.add(_weatherInformation)

        }

        return _weatherInCity

    }
}
