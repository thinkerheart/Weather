package com.thinkzi.weather.ui.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.thinkzi.weather.ui.R;
import com.thinkzi.weather.ui.databinding.ActivityListItemBinding;
import com.thinkzi.weather.ui.view.adapter.WeatherInCityUIModelForFiveDaysAdapter;
import com.thinkzi.weather.ui.viewmodel.WeatherInCityUIModelForFiveDaysViewModel;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class WeatherInCityUIModelForFiveDaysActivity extends BaseActivity {

    @Inject
    WeatherInCityUIModelForFiveDaysViewModel _weatherInCityUIModelForFiveDaysViewModel;

    // android data binding
    private ActivityListItemBinding _activityListItemBinding;

    private WeatherInCityUIModelForFiveDaysAdapter _weatherInCityUIModelForFiveDaysAdapter;

    // intent contain source context and destination context (this Activity) for Navigator
    public static Intent getCallingIntent(Context _context) {
        return new Intent(_context, WeatherInCityUIModelForFiveDaysActivity.class);
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

        _weatherInCityUIModelForFiveDaysAdapter = new WeatherInCityUIModelForFiveDaysAdapter(getApplicationContext(), new ArrayList<DateTime>(), new WeatherInCityUIModelForFiveDaysAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DateTime _dateTime) {
                Toast.makeText(WeatherInCityUIModelForFiveDaysActivity.this, _dateTime.toString(), Toast.LENGTH_LONG).show();
                _navigator.navigateToWeatherInformationUIModelListActivity(WeatherInCityUIModelForFiveDaysActivity.this);
                _weatherInCityUIModelForFiveDaysViewModel.getWeatherInformationUIModelListOfSelectedDate(_dateTime);
            }
        });

        // set adapter for RecyclerView
        _activityListItemBinding.rcvItemList.setLayoutManager(new LinearLayoutManager(WeatherInCityUIModelForFiveDaysActivity.this));
        _activityListItemBinding.rcvItemList.setAdapter(_weatherInCityUIModelForFiveDaysAdapter);

        _weatherInCityUIModelForFiveDaysViewModel.getDateTimeListMutableLiveData().observe(WeatherInCityUIModelForFiveDaysActivity.this, new Observer<List<DateTime>>() {
            @Override
            public void onChanged(List<DateTime> dateTimes) {
                _weatherInCityUIModelForFiveDaysAdapter.setDateList(dateTimes);
                Toast.makeText(WeatherInCityUIModelForFiveDaysActivity.this, dateTimes.size() + "", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //avoid using just for test
        System.exit(0);
    }
}
