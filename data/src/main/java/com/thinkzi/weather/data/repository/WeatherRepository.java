package com.thinkzi.weather.data.repository;

import com.thinkzi.weather.data.exception.NetworkConnectionException;
import com.thinkzi.weather.data.mapper.WeatherInCityDataModelMapper;
import com.thinkzi.weather.data.model.Result;
import com.thinkzi.weather.data.net.APIConnection;
import com.thinkzi.weather.domain.entity.WeatherInCity;
import com.thinkzi.weather.domain.repository.IWeatherRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

@Singleton
public class WeatherRepository implements IWeatherRepository {

    private final WeatherInCityDataModelMapper _weatherInCityDataModelMapper;

    @Inject
    public WeatherRepository(WeatherInCityDataModelMapper _weatherInCityDataModelMapper) {
        this._weatherInCityDataModelMapper = _weatherInCityDataModelMapper;
    }

    @Override
    public Single<WeatherInCity> getWeatherForFiveDaysInACity(int _cityId, String _appid) {
        return APIConnection.getInstance().getWeatherForFiveDaysInACity(_cityId, _appid).flatMap(new Function<Result, SingleSource<WeatherInCity>>() {
            @Override
            public SingleSource<WeatherInCity> apply(final Result result) throws Exception {
                return Single.create(new SingleOnSubscribe<WeatherInCity>() {
                    @Override
                    public void subscribe(SingleEmitter<WeatherInCity> emitter) throws Exception {
                        try {
                            emitter.onSuccess(_weatherInCityDataModelMapper.transform(result));
                        } catch (Exception e) {
                            emitter.onError(new NetworkConnectionException(e.getCause()));
                        }
                    }
                });
            }
        });
    }
}
