package com.thinkzi.weather.domain.usecase;

import com.thinkzi.weather.domain.entity.WeatherInCity;
import com.thinkzi.weather.domain.executor.PostExecutionThread;
import com.thinkzi.weather.domain.executor.ThreadExecutor;
import com.thinkzi.weather.domain.repository.IWeatherRepository;
import com.thinkzi.weather.domain.usecase.base.SingleUseCase;
import com.thinkzi.weather.domain.utility.check.Checker;

import javax.inject.Inject;
import io.reactivex.Single;

public final class WatchWeatherInACityForFiveDaysUseCase extends SingleUseCase<WeatherInCity, WatchWeatherInACityForFiveDaysUseCase.Ps> {

    private final IWeatherRepository _iWeatherRepository;

    @Inject
    public WatchWeatherInACityForFiveDaysUseCase(ThreadExecutor _threadExecutor, PostExecutionThread _postExecutionThread, IWeatherRepository _iWeatherRepository) {
        super(_threadExecutor, _postExecutionThread);
        this._iWeatherRepository = _iWeatherRepository;
    }

    @Override
    protected Single<WeatherInCity> buildSingleUseCase(Ps _params) {
        Checker.checkNotNull(_params);
        return _iWeatherRepository.getWeatherForFiveDaysInACity(_params._cityId, _params._appid);
    }

    public static final class Ps {

        private final int _cityId;

        private final String _appid;

        private Ps(int _cityId, String _appid) {
            this._cityId = _cityId;
            this._appid = _appid;
        }

        public static Ps forPs(int _cityId, String _appid) {
            return new Ps(_cityId, _appid);
        }

    }
}
