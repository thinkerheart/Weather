package com.thinkzi.weather.data.repository.datasource;

import com.thinkzi.weather.data.model.Result;

import io.reactivex.Single;

public class DiskResultDataStore implements IResultDataStore {

    @Override
    public Single<Result> getWeatherForFiveDaysInACity(int _id, String _appId) {
        throw new UnsupportedOperationException("Operation is not available!!!");
    }

}
