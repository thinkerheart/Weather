package com.thinkzi.weather.ui.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.thinkzi.weather.ui.viewmodel.WeatherInCityUIModelForFiveDaysViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Allow us to inject dependencies via constructor injection
 */
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(WeatherInCityUIModelForFiveDaysViewModel.class)
    abstract ViewModel bindsWeatherInCityUIModelForFiveDaysViewModel(WeatherInCityUIModelForFiveDaysViewModel _weatherInCityUIModelForFiveDaysViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory _viewModelFactory);
}
