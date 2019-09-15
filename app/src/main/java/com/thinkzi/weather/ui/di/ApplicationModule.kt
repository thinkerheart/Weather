package com.thinkzi.weather.ui.di

import android.content.Context

import com.thinkzi.weather.data.executor.JobExecutor
import com.thinkzi.weather.data.repository.WeatherRepository
import com.thinkzi.weather.domain.executor.PostExecutionThread
import com.thinkzi.weather.domain.executor.ThreadExecutor
import com.thinkzi.weather.domain.repository.IWeatherRepository
import com.thinkzi.weather.ui.WeatherApplication
import com.thinkzi.weather.ui.UIThread

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

/**
 * provide Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
class ApplicationModule(private val _weatherApplication: WeatherApplication) {

    /**
     * provide a application context
     */
    @Provides
    @Singleton
    internal fun provideApplicationContext(): Context {
        return this._weatherApplication
    }

    /**
     * provide a executor thread pool
     */
    @Provides
    @Singleton
    internal fun provideThreadExecutor(_jobExecutor: JobExecutor): ThreadExecutor {
        return _jobExecutor
    }

    /**
     * provide a thread created to change context execution
     */
    @Provides
    @Singleton
    internal fun providePostExecutionThread(_uiThread: UIThread): PostExecutionThread {
        return _uiThread
    }

    @Provides
    @Singleton
    internal fun provideIWeatherRepository(_weatherRepository: WeatherRepository): IWeatherRepository {
        return _weatherRepository
    }

}
