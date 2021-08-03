package com.example.weatherappinkotlin.models.HourlyWeather

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "HourlyWeather")
class Hourly {
    var id = 0

    @Expose
    private var clouds: Double? = null

    @SerializedName("dew_point")
    private var dewPoint: Double? = null

    @Expose
    @PrimaryKey
    @NonNull
    private var dt: Double? = null

    @SerializedName("feels_like")
    private var feelsLike: Double? = null

    @Expose
    private var humidity: Double? = null

    @Expose
    private var pop: Double? = null

    @Expose
    private var pressure: Double? = null

    @Expose
    private var temp: Double? = null

    @Expose
    private var uvi: Double? = null

    @Expose
    private var visibility: Double? = null

    @SerializedName("wind_deg")
    private var windDeg: Double? = null

    @SerializedName("wind_gust")
    private var windGust: Double? = null

    @SerializedName("wind_speed")
    private var windSpeed: Double? = null
    fun getClouds(): Double? {
        return clouds
    }

    fun getDewPoint(): Double? {
        return dewPoint
    }

    fun getDt(): Double? {
        return dt
    }

    fun getFeelsLike(): Double? {
        return feelsLike
    }

    fun getHumidity(): Double? {
        return humidity
    }

    fun getPop(): Double? {
        return pop
    }

    fun getPressure(): Double? {
        return pressure
    }

    fun getTemp(): Double? {
        return temp
    }

    fun getUvi(): Double? {
        return uvi
    }

    fun getVisibility(): Double? {
        return visibility
    }

    fun getWindDeg(): Double? {
        return windDeg
    }

    fun getWindGust(): Double? {
        return windGust
    }

    fun getWindSpeed(): Double? {
        return windSpeed
    }

    fun setClouds(clouds: Double?) {
        this.clouds = clouds
    }

    fun setDewPoint(dewPoint: Double?) {
        this.dewPoint = dewPoint
    }

    fun setDt(dt: Double) {
        this.dt = dt
    }

    fun setFeelsLike(feelsLike: Double?) {
        this.feelsLike = feelsLike
    }

    fun setHumidity(humidity: Double?) {
        this.humidity = humidity
    }

    fun setPop(pop: Double?) {
        this.pop = pop
    }

    fun setPressure(pressure: Double?) {
        this.pressure = pressure
    }

    fun setTemp(temp: Double?) {
        this.temp = temp
    }

    fun setUvi(uvi: Double?) {
        this.uvi = uvi
    }

    fun setVisibility(visibility: Double?) {
        this.visibility = visibility
    }

    fun setWindDeg(windDeg: Double?) {
        this.windDeg = windDeg
    }

    fun setWindGust(windGust: Double?) {
        this.windGust = windGust
    }

    fun setWindSpeed(windSpeed: Double?) {
        this.windSpeed = windSpeed
    }

    class Builder {
        private var clouds: Double? = null
        private var dewPoint: Double? = null
        private var dt: Double? = null
        private var feelsLike: Double? = null
        private var humidity: Double? = null
        private var pop: Double? = null
        private var pressure: Double? = null
        private var temp: Double? = null
        private var uvi: Double? = null
        private var visibility: Double? = null
        private var windDeg: Double? = null
        private var windGust: Double? = null
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

        fun withPop(pop: Double?): Builder {
            this.pop = pop
            return this
        }

        fun withPressure(pressure: Double?): Builder {
            this.pressure = pressure
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

        fun withWindDeg(windDeg: Double?): Builder {
            this.windDeg = windDeg
            return this
        }

        fun withWindGust(windGust: Double?): Builder {
            this.windGust = windGust
            return this
        }

        fun withWindSpeed(windSpeed: Double?): Builder {
            this.windSpeed = windSpeed
            return this
        }

        fun build(): Hourly {
            val hourly = Hourly()
            hourly.clouds = clouds
            hourly.dewPoint = dewPoint
            hourly.dt = dt!!
            hourly.feelsLike = feelsLike
            hourly.humidity = humidity
            hourly.pop = pop
            hourly.pressure = pressure
            hourly.temp = temp
            hourly.uvi = uvi
            hourly.visibility = visibility
            hourly.windDeg = windDeg
            hourly.windGust = windGust
            hourly.windSpeed = windSpeed
            return hourly
        }
    }
}