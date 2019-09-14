package com.thinkzi.weather.ui.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.thinkzi.weather.domain.entity.WeatherInCity;
import com.thinkzi.weather.domain.exception.DefaultErrorBundle;
import com.thinkzi.weather.domain.usecase.WatchWeatherInACityForFiveDaysUseCase;
import com.thinkzi.weather.domain.usecase.base.SingleObserver;
import com.thinkzi.weather.ui.mapper.WeatherInCityUIModelMapper;
import com.thinkzi.weather.ui.model.WeatherInCityUIModel;
import com.thinkzi.weather.ui.model.WeatherInformationUIModel;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * provide WeatherInCityUIModelForFiveDaysViewModel for operations on WeatherInCityUIModelForFiveDaysActivity: save data of View(Activity) for configuration change management,
 * treat actions from View, data binding, live data, observer result sent from UseCase ...
 * */
@Singleton
public class WeatherInCityUIModelForFiveDaysViewModel extends BaseViewModel {

    private final WatchWeatherInACityForFiveDaysUseCase _watchWeatherInACityForFiveDaysUseCase;

    private final WeatherInCityUIModelMapper _weatherInCityUIModelMapper;

    private final MutableLiveData<WeatherInCityUIModel> _weatherInCityUIModelMutableLiveData;

    private final MutableLiveData<List<DateTime>> _dateTimeListMutableLiveData;

    private final MutableLiveData<List<WeatherInformationUIModel>> _weatherInformationUIModelListOfSelectedDateMutableLiveData;

    // application context
    private final Context _context;

    @Inject
    public WeatherInCityUIModelForFiveDaysViewModel(WatchWeatherInACityForFiveDaysUseCase _watchWeatherInACityForFiveDaysUseCase, WeatherInCityUIModelMapper _weatherInCityUIModelMapper, Context _context) {
        this._watchWeatherInACityForFiveDaysUseCase = _watchWeatherInACityForFiveDaysUseCase;
        this._weatherInCityUIModelMapper = _weatherInCityUIModelMapper;
        this._weatherInCityUIModelMutableLiveData = new MutableLiveData<>();
        this._weatherInCityUIModelMutableLiveData.setValue(new WeatherInCityUIModel());
        this._dateTimeListMutableLiveData = new MutableLiveData<>();
        this._dateTimeListMutableLiveData.setValue(new ArrayList<DateTime>());
        this._weatherInformationUIModelListOfSelectedDateMutableLiveData = new MutableLiveData<>();
        this._weatherInformationUIModelListOfSelectedDateMutableLiveData.setValue(new ArrayList<WeatherInformationUIModel>());

        this._context = _context;

        getWeatherForFiveDaysInACity();
    }

    private void getWeatherForFiveDaysInACity() {
        this._watchWeatherInACityForFiveDaysUseCase.execute(new WatchWeatherInACityForFiveDaysObserver(), WatchWeatherInACityForFiveDaysUseCase.Ps.forPs(6455259, "5d8c9be1bf4ce28735d0e9fe7a4cea77"));
    }

    private void handleWeatherInCity(WeatherInCity _weatherInCity) {
        _weatherInCityUIModelMutableLiveData.setValue(_weatherInCityUIModelMapper.transform(_weatherInCity));
        _dateTimeListMutableLiveData.setValue(getDatesForWeatherInCity());
    }

    private List<DateTime> getDatesForWeatherInCity() {
        List<DateTime> _dateTimeList = new ArrayList<>();
        DateTime _temp = DateTime.now();
        List<WeatherInformationUIModel> _weatherInformationList = _weatherInCityUIModelMutableLiveData.getValue().getWeatherInformationList();

        for (int i = 0; i < _weatherInformationList.size(); i++) {

            if (i == 0) {
                _dateTimeList.add(_weatherInformationList.get(i).getDateTime());
            } else if (_weatherInformationList.get(i).getDateTime().getDayOfYear() != _temp.getDayOfYear()) {
                _dateTimeList.add(_weatherInformationList.get(i).getDateTime());
            }

            _temp = _weatherInformationList.get(i).getDateTime();

        }

        return _dateTimeList;
    }

    public void getWeatherInformationUIModelListOfSelectedDate(DateTime _dateTime) {
        List<WeatherInformationUIModel> _weatherInformationUIModelList = new ArrayList<>();

        for (WeatherInformationUIModel _weatherInformationUIModel : _weatherInCityUIModelMutableLiveData.getValue().getWeatherInformationList()) {
            if (_dateTime.getDayOfYear() == _weatherInformationUIModel.getDateTime().getDayOfYear()) {
                _weatherInformationUIModelList.add(_weatherInformationUIModel);
            }
        }

        _weatherInformationUIModelListOfSelectedDateMutableLiveData.setValue(_weatherInformationUIModelList);
    }

    private final class WatchWeatherInACityForFiveDaysObserver extends SingleObserver<WeatherInCity> {

        @Override
        public void onSuccess(WeatherInCity _weatherInCity) {
            handleWeatherInCity(_weatherInCity);
        }

        @Override
        public void onError(Throwable e) {
            handleError(new DefaultErrorBundle((Exception) e));
        }

    }

    public MutableLiveData<WeatherInCityUIModel> getWeatherInCityUIModelMutableLiveData() {
        return _weatherInCityUIModelMutableLiveData;
    }

    public MutableLiveData<List<DateTime>> getDateTimeListMutableLiveData() {
        return _dateTimeListMutableLiveData;
    }

    public MutableLiveData<List<WeatherInformationUIModel>> getWeatherInformationUIModelListOfSelectedDateMutableLiveData() {
        return _weatherInformationUIModelListOfSelectedDateMutableLiveData;
    }
}
