package com.thinkzi.weather.data.repository

import com.thinkzi.weather.data.exception.NetworkConnectionException
import com.thinkzi.weather.data.mapper.WeatherInCityDataModelMapper
import com.thinkzi.weather.data.model.Result
import com.thinkzi.weather.data.net.APIConnection
import com.thinkzi.weather.domain.entity.WeatherInCity
import com.thinkzi.weather.domain.repository.IWeatherRepository

import javax.inject.Inject
import javax.inject.Singleton
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.functions.Function

@Singleton
class WeatherRepository @Inject
constructor(private val _weatherInCityDataModelMapper: WeatherInCityDataModelMapper) :
    IWeatherRepository {

    override fun getWeatherForFiveDaysInACity(_cityId: Int, _appId: String): Single<WeatherInCity> {
        return APIConnection.instance.getWeatherForFiveDaysInACity(_cityId, _appId)
            .flatMap(Function<Result, SingleSource<WeatherInCity>> { result ->
                Single.create { emitter ->
                    try {
                        emitter.onSuccess(_weatherInCityDataModelMapper.transform(result))
                    } catch (e: Exception) {
                        emitter.onError(NetworkConnectionException(e.cause!!))
                    }
                }
            })
    }
}
