package com.thinkzi.weather.ui.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkzi.weather.ui.R;
import com.thinkzi.weather.ui.databinding.ItemWeatherInformationBinding;
import com.thinkzi.weather.ui.model.WeatherInformationUIModel;

import java.util.List;

public class WeatherInformationUIModelListAdapter extends RecyclerView.Adapter<WeatherInformationUIModelListAdapter.WeatherInformationUIModelViewHolder>{

    // application context
    private Context _context;

    private List<WeatherInformationUIModel> _weatherInformationUIModelList;

    public WeatherInformationUIModelListAdapter(Context _context, List<WeatherInformationUIModel> _weatherInformationUIModelList) {
        this._context = _context;
        this._weatherInformationUIModelList = _weatherInformationUIModelList;
    }

    @NonNull
    @Override
    public WeatherInformationUIModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return(new WeatherInformationUIModelViewHolder(ItemWeatherInformationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)));
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherInformationUIModelViewHolder holder, int position) {
        holder.bind(_weatherInformationUIModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return _weatherInformationUIModelList.size();
    }

    public void setWeatherInformationUIModelList(List<WeatherInformationUIModel> _weatherInformationUIModelList) {
        this._weatherInformationUIModelList = _weatherInformationUIModelList;
        notifyDataSetChanged();
    }

    class WeatherInformationUIModelViewHolder extends RecyclerView.ViewHolder {

        private final ItemWeatherInformationBinding _itemWeatherInformationBinding;

        WeatherInformationUIModelViewHolder(ItemWeatherInformationBinding _itemWeatherInformationBinding) {
            super(_itemWeatherInformationBinding.getRoot());
            this._itemWeatherInformationBinding = _itemWeatherInformationBinding;
        }

        void bind(final WeatherInformationUIModel _weatherInformationUIModel) {
            /*
            _itemWeatherInformationBinding.lblDateTime.setText(_context.getString(R.string.datetime) + " : " + _weatherInformationUIModel.getDateTime().toString("HH:mm:ss dd/MM/yyyy"));
            _itemWeatherInformationBinding.lblTemperature.setText(_context.getString(R.string.temperature) + " : " + String.valueOf(_weatherInformationUIModel.getTemperature().getTemperature()));
            _itemWeatherInformationBinding.lblMinTemperature.setText(_context.getString(R.string.min_temperature) + " : " + String.valueOf(_weatherInformationUIModel.getTemperature().getMinTemperature()));
            _itemWeatherInformationBinding.lblMaxTemperature.setText(_context.getString(R.string.max_temperature) + " : " + String.valueOf(_weatherInformationUIModel.getTemperature().getMaxTemperature()));
            _itemWeatherInformationBinding.lblCloudiness.setText(_context.getString(R.string.cloudiness) + " : " + String.valueOf(_weatherInformationUIModel.getCloud().getCloudiness()));
            _itemWeatherInformationBinding.lblHumidity.setText(_context.getString(R.string.humidity) + " : " + String.valueOf(_weatherInformationUIModel.getHumidity().getHumidity()));
            _itemWeatherInformationBinding.lblPressure.setText(_context.getString(R.string.pressure) + " : " + String.valueOf(_weatherInformationUIModel.getPressure().getPressure()));
            _itemWeatherInformationBinding.lblRainVolume.setText(_context.getString(R.string.rain_volume) + " : " + String.valueOf(_weatherInformationUIModel.getRain().getRainVolume()));
            _itemWeatherInformationBinding.lblSnowVolume.setText(_context.getString(R.string.snow_volume) + " : " + String.valueOf(_weatherInformationUIModel.getSnow().getSnowVolume()));
            _itemWeatherInformationBinding.lblWindSpeed.setText(_context.getString(R.string.wind_speed) + " : " + String.valueOf(_weatherInformationUIModel.getWind().getSpeed()));
            _itemWeatherInformationBinding.lblWindDirection.setText(_context.getString(R.string.wind_direction) + " : " + String.valueOf(_weatherInformationUIModel.getWind().getDirection()));
            */

            _itemWeatherInformationBinding.setWeatherInformationUIModel(_weatherInformationUIModel);

            _itemWeatherInformationBinding.executePendingBindings();

        }

    }
}
