package com.thinkzi.weather.ui.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.thinkzi.weather.ui.R;
import com.thinkzi.weather.ui.databinding.ActivityListItemBinding;
import com.thinkzi.weather.ui.model.WeatherInformationUIModel;
import com.thinkzi.weather.ui.view.adapter.WeatherInformationUIModelListAdapter;
import com.thinkzi.weather.ui.viewmodel.WeatherInCityUIModelForFiveDaysViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class WeatherInformationUIModelListActivity extends BaseActivity {

    @Inject
    WeatherInCityUIModelForFiveDaysViewModel _weatherInCityUIModelForFiveDaysViewModel;

    // android data binding
    private ActivityListItemBinding _activityListItemBinding;

    private WeatherInformationUIModelListAdapter _weatherInformationUIModelListAdapter;

    // intent contain source context and destination context (this Activity) for Navigator
    public static Intent getCallingIntent(Context _context) {
        return new Intent(_context, WeatherInformationUIModelListActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // inject dependancy for this Activity
        this.getApplicationComponent().inject(this);

        // android data binding
        _activityListItemBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_item);

        _activityListItemBinding.setLifecycleOwner(this);

        // set viewmodel for databiding
        _activityListItemBinding.setWeatherInCityUIModelForFiveDaysViewModel(_weatherInCityUIModelForFiveDaysViewModel);

        _weatherInformationUIModelListAdapter = new WeatherInformationUIModelListAdapter(getApplicationContext(), new ArrayList<WeatherInformationUIModel>());

        // set adapter for RecyclerView
        _activityListItemBinding.rcvItemList.setLayoutManager(new LinearLayoutManager(WeatherInformationUIModelListActivity.this));
        _activityListItemBinding.rcvItemList.setAdapter(_weatherInformationUIModelListAdapter);

        _weatherInCityUIModelForFiveDaysViewModel.getWeatherInformationUIModelListOfSelectedDateMutableLiveData().observe(WeatherInformationUIModelListActivity.this, new Observer<List<WeatherInformationUIModel>>() {
            @Override
            public void onChanged(List<WeatherInformationUIModel> weatherInformationUIModels) {
                _weatherInformationUIModelListAdapter.setWeatherInformationUIModelList(weatherInformationUIModels);
            }
        });

    }
}
