package com.thinkzi.weather.ui.navigation

import android.content.Context
import android.content.Intent

import com.thinkzi.weather.ui.view.activity.WeatherInCityUIModelForFiveDaysActivity
import com.thinkzi.weather.ui.view.activity.WeatherInformationUIModelListActivity

import javax.inject.Inject
import javax.inject.Singleton

/**
 * provide a navigator used to navigate through the application.
 */
@Singleton
class Navigator @Inject
constructor() {

    fun navigateToWeatherInCityUIModelForFiveDaysActivity(_context: Context?) {

        if (_context != null) {
            val _intent = WeatherInCityUIModelForFiveDaysActivity.getCallingIntent(_context)
            _context.startActivity(_intent)
        }

    }

    fun navigateToWeatherInformationUIModelListActivity(_context: Context?) {

        if (_context != null) {
            val _intent = WeatherInformationUIModelListActivity.getCallingIntent(_context)
            _context.startActivity(_intent)
        }

    }

}
