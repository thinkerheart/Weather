package com.thinkzi.weather.ui.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thinkzi.weather.ui.viewmodel.WeatherInCityUIModelForFiveDaysViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Allow us to inject dependencies via constructor injection
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(WeatherInCityUIModelForFiveDaysViewModel::class)
    internal abstract fun bindsWeatherInCityUIModelForFiveDaysViewModel(
        _weatherInCityUIModelForFiveDaysViewModel: WeatherInCityUIModelForFiveDaysViewModel
    ): ViewModel

    @Binds
    internal abstract fun bindsViewModelFactory(_viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
