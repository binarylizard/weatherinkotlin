package com.example.weatherappinkotlin.retrofit

import com.example.weatherappinkotlin.models.HourlyWeather.OpenWeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("onecall")
    fun getHourlyWeather(
        @Query("lat") lat: Double,
        @Query("lon") longitude: Double,
        @Query("appid") appId: String?,
        @Query("units") units: String?
    ): Call<OpenWeatherResponse?>?
}