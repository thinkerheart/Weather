package com.thinkzi.weather.ui

import android.app.Application

import com.thinkzi.weather.ui.di.ApplicationComponent
import com.thinkzi.weather.ui.di.ApplicationModule
import com.thinkzi.weather.ui.di.DaggerApplicationComponent

/**
 * provide WeatherApplication object
 */
class WeatherApplication : Application() {

    /**
     * provide ApplicationComponent
     */
    var applicationComponent: ApplicationComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        this.initializeInjector()
    }

    /**
     * initialize injector
     */
    private fun initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

}
