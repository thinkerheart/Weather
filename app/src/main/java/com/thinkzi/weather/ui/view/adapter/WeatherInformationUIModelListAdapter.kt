package com.thinkzi.weather.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.thinkzi.weather.ui.R
import com.thinkzi.weather.ui.databinding.ItemWeatherInformationBinding
import com.thinkzi.weather.ui.model.WeatherInformationUIModel

internal class WeatherInformationUIModelListAdapter(// application context
    private val _context: Context,
    private var _weatherInformationUIModelList: List<WeatherInformationUIModel>?
) : RecyclerView.Adapter<WeatherInformationUIModelListAdapter.WeatherInformationUIModelViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherInformationUIModelViewHolder {
        return WeatherInformationUIModelViewHolder(
            ItemWeatherInformationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WeatherInformationUIModelViewHolder, position: Int) {
        holder.bind(_weatherInformationUIModelList!![position])
    }

    override fun getItemCount(): Int {
        return _weatherInformationUIModelList!!.size
    }

    fun setWeatherInformationUIModelList(_weatherInformationUIModelList: List<WeatherInformationUIModel>) {
        this._weatherInformationUIModelList = _weatherInformationUIModelList
        notifyDataSetChanged()
    }

    internal inner class WeatherInformationUIModelViewHolder(private val _itemWeatherInformationBinding: ItemWeatherInformationBinding) :
        RecyclerView.ViewHolder(_itemWeatherInformationBinding.root) {

        fun bind(_weatherInformationUIModel: WeatherInformationUIModel) {
            _itemWeatherInformationBinding.lblDateTime.text =
                _context.getString(R.string.datetime) + " : " + _weatherInformationUIModel.dateTime.toString(
                    "HH:mm:ss dd/MM/yyyy"
                )
            _itemWeatherInformationBinding.lblTemperature.text =
                _context.getString(R.string.temperature) + " : " + _weatherInformationUIModel.temperature.temperature.toString()
            _itemWeatherInformationBinding.lblMinTemperature.text =
                _context.getString(R.string.min_temperature) + " : " + _weatherInformationUIModel.temperature.minTemperature.toString()
            _itemWeatherInformationBinding.lblMaxTemperature.text =
                _context.getString(R.string.max_temperature) + " : " + _weatherInformationUIModel.temperature.maxTemperature.toString()
            _itemWeatherInformationBinding.lblCloudiness.text =
                _context.getString(R.string.cloudiness) + " : " + _weatherInformationUIModel.cloud.cloudiness.toString()
            _itemWeatherInformationBinding.lblHumidity.text =
                _context.getString(R.string.humidity) + " : " + _weatherInformationUIModel.humidity.humidity.toString()
            _itemWeatherInformationBinding.lblPressure.text =
                _context.getString(R.string.pressure) + " : " + _weatherInformationUIModel.pressure.pressure.toString()
            _itemWeatherInformationBinding.lblRainVolume.text =
                _context.getString(R.string.rain_volume) + " : " + _weatherInformationUIModel.rain.rainVolume.toString()
            _itemWeatherInformationBinding.lblSnowVolume.text =
                _context.getString(R.string.snow_volume) + " : " + _weatherInformationUIModel.snow.snowVolume.toString()
            _itemWeatherInformationBinding.lblWindSpeed.text =
                _context.getString(R.string.wind_speed) + " : " + _weatherInformationUIModel.wind.speed.toString()
            _itemWeatherInformationBinding.lblWindDirection.text =
                _context.getString(R.string.wind_direction) + " : " + _weatherInformationUIModel.wind.direction.toString()

            _itemWeatherInformationBinding.executePendingBindings()

        }

    }
}
