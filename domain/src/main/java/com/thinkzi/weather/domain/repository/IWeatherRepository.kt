package com.thinkzi.weather.domain.repository

import com.thinkzi.weather.domain.entity.WeatherInCity
import io.reactivex.Single

interface IWeatherRepository {

    fun getWeatherForFiveDaysInACity(_cityId: Int, _appId: String): Single<WeatherInCity>

}
