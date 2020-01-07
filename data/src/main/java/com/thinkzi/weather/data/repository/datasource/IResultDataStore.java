package com.thinkzi.weather.data.repository.datasource;

import com.thinkzi.weather.data.model.Result;

import io.reactivex.Single;

public interface IResultDataStore {

    Single<Result> getWeatherForFiveDaysInACity(int _id, String _appId);

}
