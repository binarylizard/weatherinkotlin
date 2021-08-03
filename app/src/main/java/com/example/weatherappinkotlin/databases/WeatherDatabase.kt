package com.example.weatherappinkotlin.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weatherappinkotlin.dao.WeatherDao
import com.example.weatherappinkotlin.models.HourlyWeather.Hourly

@Database(entities = [Hourly::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao?

    companion object {
        private const val DATABASE_NAME = "Weather"

        @Volatile
        var instance: WeatherDatabase? = null
        fun getInstance(context: Context?): WeatherDatabase? {
            if (instance == null) {
                synchronized(WeatherDatabase::class.java) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context!!,
                            WeatherDatabase::class.java, DATABASE_NAME
                        )
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return instance
        }
    }
}