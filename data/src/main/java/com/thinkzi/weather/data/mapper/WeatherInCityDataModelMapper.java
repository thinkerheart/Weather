package com.thinkzi.weather.data.mapper;

import com.thinkzi.weather.data.model.List;
import com.thinkzi.weather.data.model.Result;
import com.thinkzi.weather.data.model.Weather;
import com.thinkzi.weather.domain.entity.WeatherCondition;
import com.thinkzi.weather.domain.entity.WeatherInCity;
import com.thinkzi.weather.domain.entity.WeatherInformation;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class WeatherInCityDataModelMapper {

    @Inject
    public WeatherInCityDataModelMapper() {
    }

    public WeatherInCity transform(Result _result) {

        if (_result == null)
            throw new IllegalArgumentException("Cannot transform a null Result");

        final WeatherInCity _weatherInCity = new WeatherInCity();

        _weatherInCity.getCity().setId(_result.getCity().getId());
        _weatherInCity.getCity().setName(_result.getCity().getName());
        _weatherInCity.getCity().setCountry(_result.getCity().getCountry());
        _weatherInCity.getCity().getCoordinate().setLongitude(_result.getCity().getCoord().getLon());
        _weatherInCity.getCity().getCoordinate().setLatitude(_result.getCity().getCoord().getLat());

        _weatherInCity.setWeatherInformationList(new ArrayList<WeatherInformation>());

        for (List _list : _result.getList()) {

            WeatherInformation _weatherInformation = new WeatherInformation();
            _weatherInformation.setDateTime(new DateTime(Instant.ofEpochSecond(_list.getDt()), DateTimeZone.getDefault()));
            _weatherInformation.getCloud().setCloudiness(_list.getClouds().getAll());
            _weatherInformation.getHumidity().setHumidity(_list.getMain().getHumidity());
            _weatherInformation.getPressure().setPressure(_list.getMain().getPressure());
            _weatherInformation.getRain().setRainVolume(_list.getRain().getRainVolume());
            _weatherInformation.getSnow().setSnowVolume(_list.getSnow().getSnowVolume());
            _weatherInformation.getWind().setSpeed(_list.getWind().getSpeed());
            _weatherInformation.getWind().setDirection(_list.getWind().getDeg());
            _weatherInformation.getTemperature().setMaxTemperature(_list.getMain().getTempMax());
            _weatherInformation.getTemperature().setMinTemperature(_list.getMain().getTempMin());
            _weatherInformation.getTemperature().setTemperature(_list.getMain().getTemp());
            _weatherInformation.setWeatherConditionInformationList(new ArrayList<WeatherCondition>());

            for (Weather _weather : _list.getWeather()) {

                WeatherCondition _weatherCondition = new WeatherCondition();
                _weatherCondition.setId(_weather.getId());
                _weatherCondition.setCondition(_weather.getMain());
                _weatherCondition.setDescription(_weather.getDescription());
                _weatherCondition.setIcon(_weather.getIcon());

                _weatherInformation.getWeatherConditionInformationList().add(_weatherCondition);

            }

            _weatherInCity.getWeatherInformationList().add(_weatherInformation);

        }

        return _weatherInCity;

    }
}
