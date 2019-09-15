package com.thinkzi.weather.ui.viewmodel

import android.content.Context

import androidx.lifecycle.MutableLiveData

import com.thinkzi.weather.domain.entity.WeatherInCity
import com.thinkzi.weather.domain.exception.DefaultErrorBundle
import com.thinkzi.weather.domain.usecase.WatchWeatherInACityForFiveDaysUseCase
import com.thinkzi.weather.domain.usecase.base.SingleObserver
import com.thinkzi.weather.ui.mapper.WeatherInCityUIModelMapper
import com.thinkzi.weather.ui.model.WeatherInCityUIModel
import com.thinkzi.weather.ui.model.WeatherInformationUIModel

import org.joda.time.DateTime

import java.util.ArrayList

import javax.inject.Inject
import javax.inject.Singleton

/**
 * provide WeatherInCityUIModelForFiveDaysViewModel for operations on WeatherInCityUIModelForFiveDaysActivity: save data of View(Activity) for configuration change management,
 * treat actions from View, data binding, live data, observer result sent from UseCase ...
 */
@Singleton
class WeatherInCityUIModelForFiveDaysViewModel @Inject
constructor(
    val _watchWeatherInACityForFiveDaysUseCase: WatchWeatherInACityForFiveDaysUseCase,
    val _weatherInCityUIModelMapper: WeatherInCityUIModelMapper, // application context
    val _context: Context
) : BaseViewModel() {

    val weatherInCityUIModelMutableLiveData: MutableLiveData<WeatherInCityUIModel>

    val dateTimeListMutableLiveData: MutableLiveData<List<DateTime>>

    val weatherInformationUIModelListOfSelectedDateMutableLiveData: MutableLiveData<List<WeatherInformationUIModel>>

    private val datesForWeatherInCity: List<DateTime>
        get() {
            val _dateTimeList = ArrayList<DateTime>()
            var _temp = DateTime.now()
            val _weatherInformationList =
                weatherInCityUIModelMutableLiveData.value!!.weatherInformationList

            for (i in _weatherInformationList.indices) {

                if (i == 0) {
                    _dateTimeList.add(_weatherInformationList[i].dateTime)
                } else if (_weatherInformationList[i].dateTime.dayOfYear != _temp.dayOfYear) {
                    _dateTimeList.add(_weatherInformationList[i].dateTime)
                }

                _temp = _weatherInformationList[i].dateTime

            }

            return _dateTimeList
        }

    init {
        this.weatherInCityUIModelMutableLiveData = MutableLiveData()
        this.weatherInCityUIModelMutableLiveData.value = WeatherInCityUIModel()
        this.dateTimeListMutableLiveData = MutableLiveData()
        this.dateTimeListMutableLiveData.value = ArrayList()
        this.weatherInformationUIModelListOfSelectedDateMutableLiveData = MutableLiveData()
        this.weatherInformationUIModelListOfSelectedDateMutableLiveData.value = ArrayList()

        getWeatherForFiveDaysInACity()
    }

    private fun getWeatherForFiveDaysInACity() {
        this._watchWeatherInACityForFiveDaysUseCase.execute(
            WatchWeatherInACityForFiveDaysObserver(),
            WatchWeatherInACityForFiveDaysUseCase.Ps.forPs(
                6455259,
                "5d8c9be1bf4ce28735d0e9fe7a4cea77"
            )
        )
    }

    private fun handleWeatherInCity(_weatherInCity: WeatherInCity) {
        weatherInCityUIModelMutableLiveData.value =
            _weatherInCityUIModelMapper.transform(_weatherInCity)
        dateTimeListMutableLiveData.value = datesForWeatherInCity
    }

    fun getWeatherInformationUIModelListOfSelectedDate(_dateTime: DateTime) {
        val _weatherInformationUIModelList = ArrayList<WeatherInformationUIModel>()

        for (_weatherInformationUIModel in weatherInCityUIModelMutableLiveData.value!!.weatherInformationList) {
            if (_dateTime.dayOfYear == _weatherInformationUIModel.dateTime.dayOfYear) {
                _weatherInformationUIModelList.add(_weatherInformationUIModel)
            }
        }

        weatherInformationUIModelListOfSelectedDateMutableLiveData.value =
            _weatherInformationUIModelList
    }

    private inner class WatchWeatherInACityForFiveDaysObserver : SingleObserver<WeatherInCity>() {

        override fun onSuccess(t: WeatherInCity) {
            handleWeatherInCity(t)
        }

        override fun onError(e: Throwable) {
            handleError(DefaultErrorBundle(e as Exception))
        }

    }
}
