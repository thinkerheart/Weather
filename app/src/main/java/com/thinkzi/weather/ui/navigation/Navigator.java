package com.thinkzi.weather.ui.navigation;

import android.content.Context;
import android.content.Intent;

import com.thinkzi.weather.ui.view.activity.WeatherInCityUIModelForFiveDaysActivity;
import com.thinkzi.weather.ui.view.activity.WeatherInformationUIModelListActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * provide a navigator used to navigate through the application.
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() { }

    public void navigateToWeatherInCityUIModelForFiveDaysActivity(Context _context) {

        if (_context != null) {
            Intent _intent = WeatherInCityUIModelForFiveDaysActivity.getCallingIntent(_context);
            _context.startActivity(_intent);
        }

    }

    public void navigateToWeatherInformationUIModelListActivity(Context _context) {

        if (_context != null) {
            Intent _intent = WeatherInformationUIModelListActivity.getCallingIntent(_context);
            _context.startActivity(_intent);
        }

    }

}
