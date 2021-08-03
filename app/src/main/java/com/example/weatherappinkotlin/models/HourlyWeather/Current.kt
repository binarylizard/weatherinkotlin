package com.example.weatherappinkotlin.models.HourlyWeather

import androidx.annotation.NonNull
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Current {
    @Expose
    var clouds: Double? = null
        get() = field
        private set

    @SerializedName("dew_point")
    var dewPoint: Double? = null
        get() = field
        private set

    @Expose
    var dt: Double? = null
        get() = field
        private set

    @SerializedName("feels_like")
    var feelsLike: Double? = null
        get() = field
        private set

    @Expose
    var humidity: Double? = null
        get() = field
        private set

    @Expose
    var pressure: Double? = null
        get() = field
        private set

    @Expose
    var sunrise: Double? = null
        get() = field
        private set

    @Expose
    var sunset: Double? = null
        get() = field
        private set

    @Expose
    var temp: Double? = null
        get() = field
        private set

    @Expose
    var uvi: Double? = null
        get() = field
        private set

    @Expose
    var visibility: Double? = null
        get() = field
        private set

    @Expose
    private var weather: List<Weather>? = null

    @SerializedName("wind_deg")
    var windDeg: Double? = null
        private set

    @SerializedName("wind_speed")
    var windSpeed: Double? = null
        private set

    fun getWeather(): List<Weather>? {
        return weather
    }

    class Builder {
        private var clouds: Double? = null
        private var dewPoint: Double? = null
        private var dt: Double? = null
        private var feelsLike: Double? = null
        private var humidity: Double? = null
        private var pressure: Double? = null
        private var sunrise: Double? = null
        private var sunset: Double? = null
        private var temp: Double? = null
        private var uvi: Double? = null
        private var visibility: Double? = null
        private var weather: List<Weather>? = null
        private var windDeg: Double? = null
        private var windSpeed: Double? = null
        fun withClouds(clouds: Double?): Builder {
            this.clouds = clouds
            return this
        }

        fun withDewPoint(dewPoint: Double?): Builder {
            this.dewPoint = dewPoint
            return this
        }

        fun withDt(dt: Double?): Builder {
            this.dt = dt
            return this
        }

        fun withFeelsLike(feelsLike: Double?): Builder {
            this.feelsLike = feelsLike
            return this
        }

        fun withHumidity(humidity: Double?): Builder {
            this.humidity = humidity
            return this
        }

        fun withPressure(pressure: Double?): Builder {
            this.pressure = pressure
            return this
        }

        fun withSunrise(sunrise: Double?): Builder {
            this.sunrise = sunrise
            return this
        }

        fun withSunset(sunset: Double?): Builder {
            this.sunset = sunset
            return this
        }

        fun withTemp(temp: Double?): Builder {
            this.temp = temp
            return this
        }

        fun withUvi(uvi: Double?): Builder {
            this.uvi = uvi
            return this
        }

        fun withVisibility(visibility: Double?): Builder {
            this.visibility = visibility
            return this
        }

        fun withWeather(weather: List<Weather>?): Builder {
            this.weather = weather
            return this
        }

        fun withWindDeg(windDeg: Double?): Builder {
            this.windDeg = windDeg
            return this
        }

        fun withWindSpeed(windSpeed: Double?): Builder {
            this.windSpeed = windSpeed
            return this
        }

        fun build(): Current {
            val current = Current()
            current.clouds = clouds
            current.dewPoint = dewPoint
            current.dt = dt
            current.feelsLike = feelsLike
            current.humidity = humidity
            current.pressure = pressure
            current.sunrise = sunrise
            current.sunset = sunset
            current.temp = temp
            current.uvi = uvi
            current.visibility = visibility
            current.weather = weather
            current.windDeg = windDeg
            current.windSpeed = windSpeed
            return current
        }
    }
}