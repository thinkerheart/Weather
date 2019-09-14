package com.thinkzi.weather.ui.di;

import android.content.Context;

import com.thinkzi.weather.data.executor.JobExecutor;
import com.thinkzi.weather.data.repository.WeatherRepository;
import com.thinkzi.weather.domain.executor.PostExecutionThread;
import com.thinkzi.weather.domain.executor.ThreadExecutor;
import com.thinkzi.weather.domain.repository.IWeatherRepository;
import com.thinkzi.weather.ui.WeatherApplication;
import com.thinkzi.weather.ui.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * provide Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {

    private final WeatherApplication _weatherApplication;

    public ApplicationModule(WeatherApplication _weatherApplication) {
        this._weatherApplication = _weatherApplication;
    }

    /**
     * provide a application context
     */
    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this._weatherApplication;
    }

    /**
     * provide a executor thread pool
     */
    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor _jobExecutor) {
        return _jobExecutor;
    }

    /**
     * provide a thread created to change context execution
     */
    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread _uiThread) {
        return _uiThread;
    }

    @Provides
    @Singleton
    IWeatherRepository provideIWeatherRepository(WeatherRepository _weatherRepository) {
        return _weatherRepository;
    }

}
