package com.thinkzi.weather.ui.di;

import com.thinkzi.weather.ui.WeatherApplication;
import com.thinkzi.weather.ui.view.activity.BaseActivity;
import com.thinkzi.weather.ui.view.activity.WeatherInCityUIModelForFiveDaysActivity;
import com.thinkzi.weather.ui.view.activity.WeatherInformationUIModelListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * provide a component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {ApplicationModule.class, ViewModelModule.class})
public interface ApplicationComponent {

    /**
     * inject dependency for WeatherApplication
     */
    void inject(WeatherApplication _weatherApplication);

    /**
     * inject dependency for BaseActivity
     */
    void inject(BaseActivity _baseActivity);

    void inject(WeatherInCityUIModelForFiveDaysActivity _weatherInCityUIModelForFiveDaysActivity);

    void inject(WeatherInformationUIModelListActivity _weatherInformationUIModelListActivity);

}
