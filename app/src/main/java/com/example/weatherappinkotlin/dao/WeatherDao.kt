package com.example.weatherappinkotlin.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.weatherappinkotlin.models.HourlyWeather.Hourly

@Dao
interface WeatherDao {
    @Insert
    fun insert(weatherItems: List<Hourly?>?)

    @get:Query("select * from HourlyWeather")
    val allData: LiveData<List<Hourly>>
}