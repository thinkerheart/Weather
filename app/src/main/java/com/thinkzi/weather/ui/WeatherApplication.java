package com.thinkzi.weather.ui;

import android.app.Application;

import com.thinkzi.weather.ui.di.ApplicationComponent;
import com.thinkzi.weather.ui.di.ApplicationModule;
import com.thinkzi.weather.ui.di.DaggerApplicationComponent;

/**
 * provide WeatherApplication object
 * */
public class WeatherApplication extends Application {

    private ApplicationComponent _applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    /**
     * initialize injector
     * */
    private void initializeInjector() {
        this._applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    /**
     * provide ApplicationComponent
     * */
    public ApplicationComponent getApplicationComponent() {
        return this._applicationComponent;
    }

}
