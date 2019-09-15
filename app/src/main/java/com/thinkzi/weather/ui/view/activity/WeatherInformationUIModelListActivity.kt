package com.thinkzi.weather.ui.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.thinkzi.weather.ui.R
import com.thinkzi.weather.ui.databinding.ActivityListItemBinding
import com.thinkzi.weather.ui.model.WeatherInformationUIModel
import com.thinkzi.weather.ui.view.adapter.WeatherInformationUIModelListAdapter
import com.thinkzi.weather.ui.viewmodel.WeatherInCityUIModelForFiveDaysViewModel

import java.util.ArrayList

import javax.inject.Inject

class WeatherInformationUIModelListActivity : BaseActivity() {

    @Inject
    lateinit var _weatherInCityUIModelForFiveDaysViewModel: WeatherInCityUIModelForFiveDaysViewModel

    // android data binding
    private var _activityListItemBinding: ActivityListItemBinding? = null

    private var _weatherInformationUIModelListAdapter: WeatherInformationUIModelListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inject dependancy for this Activity
        this.applicationComponent!!.inject(this)

        // android data binding
        _activityListItemBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_item)

        _activityListItemBinding!!.lifecycleOwner = this

        // set viewmodel for databiding
        _activityListItemBinding!!.weatherInCityUIModelForFiveDaysViewModel =
            _weatherInCityUIModelForFiveDaysViewModel

        _weatherInformationUIModelListAdapter =
            WeatherInformationUIModelListAdapter(applicationContext, ArrayList())

        // set adapter for RecyclerView
        _activityListItemBinding!!.rcvItemList.layoutManager =
            LinearLayoutManager(this@WeatherInformationUIModelListActivity)
        _activityListItemBinding!!.rcvItemList.adapter = _weatherInformationUIModelListAdapter

        _weatherInCityUIModelForFiveDaysViewModel.weatherInformationUIModelListOfSelectedDateMutableLiveData.observe(
            this@WeatherInformationUIModelListActivity,
            Observer { weatherInformationUIModels ->
                _weatherInformationUIModelListAdapter!!.setWeatherInformationUIModelList(
                    weatherInformationUIModels
                )
            })

    }

    companion object {

        // intent contain source context and destination context (this Activity) for Navigator
        fun getCallingIntent(_context: Context): Intent {
            return Intent(_context, WeatherInformationUIModelListActivity::class.java)
        }
    }
}
