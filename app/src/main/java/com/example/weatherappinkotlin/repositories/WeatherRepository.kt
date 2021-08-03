package com.example.weatherappinkotlin.repositories

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.weatherappinkotlin.adapters.WeatherAdapter
import com.example.weatherappinkotlin.dao.WeatherDao
import com.example.weatherappinkotlin.databases.WeatherDatabase
import com.example.weatherappinkotlin.models.HourlyWeather.Hourly

class WeatherRepository(application: Application?) {

    private val weatherDatabase: WeatherDatabase?
    private val listMutableLiveData: LiveData<List<Hourly>>

    fun insert(list: List<Hourly?>?) {
        InsertAsyncTask(weatherDatabase).execute(list)
    }

    val allData: LiveData<List<Hourly>>
        get() = listMutableLiveData

    internal inner class InsertAsyncTask(weatherDatabase: WeatherDatabase?) : AsyncTask<List<Hourly?>?, Void?, Void?>() {
        private val weatherDao: WeatherDao?
        override fun doInBackground(vararg lists: List<Hourly?>?): Void? {
            try {
                weatherDao!!.insert(lists[0])
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        }

        init {
            weatherDao = weatherDatabase!!.weatherDao()
        }
    }

    companion object {
        private val instance: WeatherAdapter? = null
    }

    init {
        weatherDatabase = WeatherDatabase.getInstance(application)
        listMutableLiveData = weatherDatabase!!.weatherDao()!!.allData
    }
}