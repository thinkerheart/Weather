package com.thinkzi.weather.domain.usecase

import com.thinkzi.weather.domain.entity.WeatherInCity
import com.thinkzi.weather.domain.executor.PostExecutionThread
import com.thinkzi.weather.domain.executor.ThreadExecutor
import com.thinkzi.weather.domain.repository.IWeatherRepository
import com.thinkzi.weather.domain.usecase.base.SingleUseCase
import com.thinkzi.weather.domain.utility.check.Checker

import javax.inject.Inject
import io.reactivex.Single

class WatchWeatherInACityForFiveDaysUseCase @Inject
constructor(
    _threadExecutor: ThreadExecutor,
    _postExecutionThread: PostExecutionThread,
    private val _iWeatherRepository: IWeatherRepository
) : SingleUseCase<WeatherInCity, WatchWeatherInACityForFiveDaysUseCase.Ps>(
    _threadExecutor,
    _postExecutionThread
) {

    override fun buildSingleUseCase(_params: Ps): Single<WeatherInCity> {
        Checker.checkNotNull(_params)
        return _iWeatherRepository.getWeatherForFiveDaysInACity(_params._cityId, _params._appid)
    }

    class Ps private constructor(internal val _cityId: Int, internal val _appid: String) {
        companion object {

            fun forPs(_cityId: Int, _appid: String): Ps {
                return Ps(_cityId, _appid)
            }
        }

    }
}
