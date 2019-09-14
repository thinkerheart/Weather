package com.thinkzi.weather.ui.mapper;

import com.thinkzi.weather.domain.entity.WeatherCondition;
import com.thinkzi.weather.domain.entity.WeatherInCity;
import com.thinkzi.weather.domain.entity.WeatherInformation;
import com.thinkzi.weather.ui.model.WeatherConditionUIModel;
import com.thinkzi.weather.ui.model.WeatherInCityUIModel;
import com.thinkzi.weather.ui.model.WeatherInformationUIModel;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class WeatherInCityUIModelMapper {

    @Inject
    public WeatherInCityUIModelMapper() {
    }

    public WeatherInCityUIModel transform(WeatherInCity _weatherInCity) {
        if (_weatherInCity == null)
            throw new IllegalArgumentException("Cannot transform a null WeatherInCity");

        WeatherInCityUIModel _weatherInCityUIModel = new WeatherInCityUIModel();
        _weatherInCityUIModel.getCity().setId(_weatherInCity.getCity().getId());
        _weatherInCityUIModel.getCity().setName(_weatherInCity.getCity().getName());
        _weatherInCityUIModel.getCity().setCountry(_weatherInCity.getCity().getCountry());
        _weatherInCityUIModel.getCity().getCoordinate().setLatitude(_weatherInCity.getCity().getCoordinate().getLatitude());
        _weatherInCityUIModel.getCity().getCoordinate().setLongitude(_weatherInCity.getCity().getCoordinate().getLongitude());

        for (WeatherInformation _weatherInformation : _weatherInCity.getWeatherInformationList()) {

            WeatherInformationUIModel _weatherInformationUIModel = new WeatherInformationUIModel();
            _weatherInformationUIModel.getCloud().setCloudiness(_weatherInformation.getCloud().getCloudiness());
            _weatherInformationUIModel.setDateTime(_weatherInformation.getDateTime());
            _weatherInformationUIModel.getHumidity().setHumidity(_weatherInformation.getHumidity().getHumidity());
            _weatherInformationUIModel.getPressure().setPressure(_weatherInformation.getPressure().getPressure());
            _weatherInformationUIModel.getRain().setRainVolume(_weatherInformation.getRain().getRainVolume());
            _weatherInformationUIModel.getSnow().setSnowVolume(_weatherInformation.getSnow().getSnowVolume());
            _weatherInformationUIModel.getTemperature().setTemperature(_weatherInformation.getTemperature().getTemperature());
            _weatherInformationUIModel.getTemperature().setMaxTemperature(_weatherInformation.getTemperature().getMaxTemperature());
            _weatherInformationUIModel.getTemperature().setMinTemperature(_weatherInformation.getTemperature().getMinTemperature());
            _weatherInformationUIModel.getWind().setDirection(_weatherInformation.getWind().getDirection());
            _weatherInformationUIModel.getWind().setSpeed(_weatherInformation.getWind().getSpeed());

            _weatherInformationUIModel.setWeatherConditionInformationList(new ArrayList<WeatherConditionUIModel>());

            for (WeatherCondition _weatherCondition : _weatherInformation.getWeatherConditionInformationList()) {

                WeatherConditionUIModel _weatherConditionUIModel = new WeatherConditionUIModel();
                _weatherConditionUIModel.setId(_weatherCondition.getId());
                _weatherConditionUIModel.setCondition(_weatherCondition.getCondition());
                _weatherConditionUIModel.setDescription(_weatherCondition.getDescription());
                _weatherConditionUIModel.setIcon(_weatherCondition.getIcon());

                _weatherInformationUIModel.getWeatherConditionInformationList().add(_weatherConditionUIModel);

            }

            _weatherInCityUIModel.getWeatherInformationList().add(_weatherInformationUIModel);
        }

        return _weatherInCityUIModel;
    }
}
