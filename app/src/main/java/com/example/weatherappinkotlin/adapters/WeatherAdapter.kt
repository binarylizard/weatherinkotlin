package com.example.weatherappinkotlin.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappinkotlin.R
import com.example.weatherappinkotlin.models.HourlyWeather.Hourly
import java.time.Instant
import java.util.*


class WeatherAdapter(private val context: Context, liveData: List<Hourly>?) : RecyclerView.Adapter<WeatherAdapter.Viewholder>() {
    private var hourlyWeatherList: List<Hourly>?

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_weather, parent, false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val hourlyWeather: Hourly = hourlyWeatherList!![position]
        holder.tvHumidityVal.setText(hourlyWeather.getHumidity().toString() + "%")
        holder.tvTempValue.setText(hourlyWeather.getTemp().toString() + " °C")
        holder.tvWindVal.setText(hourlyWeather.getWindSpeed().toString() + " metre/sec")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val instant = Instant.ofEpochSecond(hourlyWeather.getDt()!!.toLong())
            val date = Date.from(instant)
            holder.tvHour.setText("Weather Today at " + date.hours + ":" + date.minutes)
        }
    }

    fun getList(list: List<Hourly>) {
        hourlyWeatherList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (hourlyWeatherList != null) hourlyWeatherList!!.size else 0
    }

    inner class Viewholder(view: View) : RecyclerView.ViewHolder(view){

        lateinit var tvHumidityVal: TextView
        lateinit var tvTempValue: TextView
        lateinit var tvWindVal: TextView
        lateinit var tvHour: TextView

        init {
            tvHumidityVal = view.findViewById(R.id.tvHumidityVal)
            tvTempValue = view.findViewById(R.id.tvTempValue)
            tvWindVal = view.findViewById(R.id.tvWindVal)
            tvHour = view.findViewById(R.id.tvHour)
        }

    }

    init {
        hourlyWeatherList = liveData
    }
}