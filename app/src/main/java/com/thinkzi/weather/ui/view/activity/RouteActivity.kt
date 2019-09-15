package com.thinkzi.weather.ui.view.activity

import android.os.Bundle

/**
 * provide main first Activity
 */
class RouteActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.applicationComponent!!.inject(this)
        _navigator.navigateToWeatherInCityUIModelForFiveDaysActivity(this)
        finish()
    }
}
