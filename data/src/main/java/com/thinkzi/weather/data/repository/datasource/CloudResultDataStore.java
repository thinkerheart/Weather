package com.thinkzi.weather.data.repository.datasource;

import com.thinkzi.weather.data.model.Result;
import com.thinkzi.weather.data.net.APIConnection;
import io.reactivex.Single;

public class CloudResultDataStore implements IResultDataStore {

    @Override
    public Single<Result> getWeatherForFiveDaysInACity(int _id, String _appId) {
        return APIConnection.getInstance().getWeatherForFiveDaysInACity(_id, _appId);
    }

}
