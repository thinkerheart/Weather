package com.thinkzi.weather.ui.di

import com.thinkzi.weather.ui.WeatherApplication
import com.thinkzi.weather.ui.view.activity.BaseActivity
import com.thinkzi.weather.ui.view.activity.WeatherInCityUIModelForFiveDaysActivity
import com.thinkzi.weather.ui.view.activity.WeatherInformationUIModelListActivity

import javax.inject.Singleton

import dagger.Component

/**
 * provide a component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {

    /**
     * inject dependency for WeatherApplication
     */
    fun inject(_weatherApplication: WeatherApplication)

    /**
     * inject dependency for BaseActivity
     */
    fun inject(_baseActivity: BaseActivity)

    fun inject(_weatherInCityUIModelForFiveDaysActivity: WeatherInCityUIModelForFiveDaysActivity)

    fun inject(_weatherInformationUIModelListActivity: WeatherInformationUIModelListActivity)

}
