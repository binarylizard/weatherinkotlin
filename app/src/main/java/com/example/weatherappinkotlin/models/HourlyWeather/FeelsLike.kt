package com.example.weatherappinkotlin.models.HourlyWeather

import com.google.gson.annotations.Expose

class FeelsLike {
    @Expose
    var day: Double? = null
        private set

    @Expose
    var eve: Double? = null
        private set

    @Expose
    var morn: Double? = null
        private set

    @Expose
    var night: Double? = null
        private set

    class Builder {
        private var day: Double? = null
        private var eve: Double? = null
        private var morn: Double? = null
        private var night: Double? = null
        fun withDay(day: Double?): Builder {
            this.day = day
            return this
        }

        fun withEve(eve: Double?): Builder {
            this.eve = eve
            return this
        }

        fun withMorn(morn: Double?): Builder {
            this.morn = morn
            return this
        }

        fun withNight(night: Double?): Builder {
            this.night = night
            return this
        }

        fun build(): FeelsLike {
            val feelsLike = FeelsLike()
            feelsLike.day = day
            feelsLike.eve = eve
            feelsLike.morn = morn
            feelsLike.night = night
            return feelsLike
        }
    }
}