package com.example.weatherappinkotlin.models.HourlyWeather

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OpenWeatherResponse {
    @Expose
    var current: Current? = null
        get() = field
        private set

    @Expose
    var hourly: List<Hourly>? = null
        get() = field
        private set

    @Expose
    var lat: Double? = null
        get() = field
        private set

    @Expose
    var lon: Double? = null
        get() = field
        private set

    @Expose
    var timezone: String? = null
        get() = field
        private set

    @SerializedName("timezone_offset")
    var timezoneOffset: Long? = null
        get() = field
        private set

    class Builder {
        private var current: Current? = null
        private var hourly: List<Hourly>? = null
        private var lat: Double? = null
        private var lon: Double? = null
        private var timezone: String? = null
        private var timezoneOffset: Long? = null
        fun withCurrent(current: Current?): Builder {
            this.current = current
            return this
        }

        fun withHourly(hourly: List<Hourly>?): Builder {
            this.hourly = hourly
            return this
        }

        fun withLat(lat: Double?): Builder {
            this.lat = lat
            return this
        }

        fun withLon(lon: Double?): Builder {
            this.lon = lon
            return this
        }

        fun withTimezone(timezone: String?): Builder {
            this.timezone = timezone
            return this
        }

        fun withTimezoneOffset(timezoneOffset: Long?): Builder {
            this.timezoneOffset = timezoneOffset
            return this
        }

        fun build(): OpenWeatherResponse {
            val openWeatherResponse = OpenWeatherResponse()
            openWeatherResponse.current = current
            openWeatherResponse.hourly = hourly
            openWeatherResponse.lat = lat
            openWeatherResponse.lon = lon
            openWeatherResponse.timezone = timezone
            openWeatherResponse.timezoneOffset = timezoneOffset
            return openWeatherResponse
        }
    }


}