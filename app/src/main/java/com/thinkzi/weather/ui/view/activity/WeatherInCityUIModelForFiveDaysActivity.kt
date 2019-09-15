package com.thinkzi.weather.ui.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.thinkzi.weather.ui.R
import com.thinkzi.weather.ui.databinding.ActivityListItemBinding
import com.thinkzi.weather.ui.view.adapter.WeatherInCityUIModelForFiveDaysAdapter
import com.thinkzi.weather.ui.viewmodel.WeatherInCityUIModelForFiveDaysViewModel

import org.joda.time.DateTime

import java.util.ArrayList

import javax.inject.Inject

class WeatherInCityUIModelForFiveDaysActivity : BaseActivity() {

    @Inject
    lateinit var _weatherInCityUIModelForFiveDaysViewModel: WeatherInCityUIModelForFiveDaysViewModel

    // android data binding
    private var _activityListItemBinding: ActivityListItemBinding? = null

    private var _weatherInCityUIModelForFiveDaysAdapter: WeatherInCityUIModelForFiveDaysAdapter? = null

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

        _weatherInCityUIModelForFiveDaysAdapter = WeatherInCityUIModelForFiveDaysAdapter(
            applicationContext,
            ArrayList(),
            object : WeatherInCityUIModelForFiveDaysAdapter.OnItemClickListener {
                override fun onItemClick(_dateTime: DateTime) {
                    Toast.makeText(
                        this@WeatherInCityUIModelForFiveDaysActivity,
                        _dateTime.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                    _navigator.navigateToWeatherInformationUIModelListActivity(this@WeatherInCityUIModelForFiveDaysActivity)
                    _weatherInCityUIModelForFiveDaysViewModel.getWeatherInformationUIModelListOfSelectedDate(
                        _dateTime
                    )
                }
            })

        // set adapter for RecyclerView
        _activityListItemBinding!!.rcvItemList.layoutManager =
            LinearLayoutManager(this@WeatherInCityUIModelForFiveDaysActivity)
        _activityListItemBinding!!.rcvItemList.adapter = _weatherInCityUIModelForFiveDaysAdapter

        _weatherInCityUIModelForFiveDaysViewModel.dateTimeListMutableLiveData.observe(
            this@WeatherInCityUIModelForFiveDaysActivity,
            Observer { dateTimes ->
                _weatherInCityUIModelForFiveDaysAdapter!!.setDateList(dateTimes)
                Toast.makeText(
                    this@WeatherInCityUIModelForFiveDaysActivity,
                    dateTimes.size.toString() + "",
                    Toast.LENGTH_LONG
                ).show()
            })

    }

    override fun onBackPressed() {
        super.onBackPressed()
        //avoid using just for test
        System.exit(0)
    }

    companion object {

        // intent contain source context and destination context (this Activity) for Navigator
        fun getCallingIntent(_context: Context): Intent {
            return Intent(_context, WeatherInCityUIModelForFiveDaysActivity::class.java)
        }
    }
}
