package com.thinkzi.weather.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.thinkzi.weather.ui.databinding.ItemDateBinding

import org.joda.time.DateTime
import java.util.Locale

internal class WeatherInCityUIModelForFiveDaysAdapter(// application context
    private val _context: Context,
    private var _dateList: List<DateTime>?, // listener for onItemClick
    private val _onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<WeatherInCityUIModelForFiveDaysAdapter.DateViewHolder>() {

    /**
     * provide listener for onItemClick
     */
    interface OnItemClickListener {

        fun onItemClick(_dateTime: DateTime)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {

        return DateViewHolder(
            ItemDateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {

        holder.bind(_dateList!![position], _onItemClickListener)

    }

    override fun getItemCount(): Int {
        return _dateList!!.size
    }

    fun setDateList(_dateList: List<DateTime>) {

        this._dateList = _dateList

        notifyDataSetChanged()
    }

    private fun showDate(_dateTime: DateTime): String {
        val pDoW = _dateTime.dayOfWeek()
        val strTF = pDoW.getAsText(Locale.getDefault())

        return strTF + " " + _dateTime.toString("dd/MM/yyyy")
    }

    /**
     * provide a viewholder to bind data
     */
    internal inner class DateViewHolder(private val _itemDateBinding: ItemDateBinding) :
        RecyclerView.ViewHolder(_itemDateBinding.root) {

        fun bind(_dateTime: DateTime, _onItemClickListener: OnItemClickListener) {
            _itemDateBinding.lblDate.text = showDate(_dateTime)

            _itemDateBinding.executePendingBindings()

            _itemDateBinding.root.setOnClickListener { _onItemClickListener.onItemClick(_dateTime) }

        }

    }
}
