package com.thinkzi.weather.domain.repository;

import com.thinkzi.weather.domain.entity.WeatherInCity;
import io.reactivex.Single;

public interface IWeatherRepository {

    Single<WeatherInCity> getWeatherForFiveDaysInACity(int _cityId, String _appId);

}
