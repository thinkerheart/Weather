package com.thinkzi.weather.ui.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkzi.weather.ui.databinding.ItemDateBinding;

import org.joda.time.DateTime;

import java.util.List;
import java.util.Locale;

public class WeatherInCityUIModelForFiveDaysAdapter extends RecyclerView.Adapter<WeatherInCityUIModelForFiveDaysAdapter.DateViewHolder> {

    /**
     * provide listener for onItemClick
     * */
    public interface OnItemClickListener {

        void onItemClick(DateTime _dateTime);

    }

    private List<DateTime> _dateList;

    // listener for onItemClick
    private OnItemClickListener _onItemClickListener;

    // application context
    private Context _context;

    public WeatherInCityUIModelForFiveDaysAdapter(Context _context, List<DateTime> _dateList, OnItemClickListener _onItemClickListener) {

        this._context = _context;

        this._dateList = _dateList;

        this._onItemClickListener = _onItemClickListener;
    }

    @NonNull
    @Override
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return(new DateViewHolder(ItemDateBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false)));

    }

    @Override
    public void onBindViewHolder(@NonNull DateViewHolder holder, int position) {

        holder.bind(_dateList.get(position), _onItemClickListener);

    }

    @Override
    public int getItemCount() {
        return _dateList.size();
    }

    public void setDateList(List<DateTime> _dateList) {

        this._dateList = _dateList;

        notifyDataSetChanged();
    }

    private String showDate(DateTime _dateTime) {
        DateTime.Property pDoW = _dateTime.dayOfWeek();
        String strTF = pDoW.getAsText(Locale.getDefault());

        return strTF + " " + _dateTime.toString("dd/MM/yyyy");
    }

    /**
     * provide a viewholder to bind data
     * */
    class DateViewHolder extends RecyclerView.ViewHolder {

        private final ItemDateBinding _itemDateBinding;

        DateViewHolder(ItemDateBinding _itemDateBinding) {
            super(_itemDateBinding.getRoot());
            this._itemDateBinding = _itemDateBinding;
        }

        void bind(final DateTime _dateTime, final OnItemClickListener _onItemClickListener) {
            _itemDateBinding.lblDate.setText(showDate(_dateTime));

            _itemDateBinding.executePendingBindings();

            _itemDateBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _onItemClickListener.onItemClick(_dateTime);
                }
            });

        }

    }
}
