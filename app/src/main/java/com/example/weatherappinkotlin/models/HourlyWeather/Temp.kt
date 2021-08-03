package com.example.weatherappinkotlin.models.HourlyWeather

import com.google.gson.annotations.Expose

class Temp {
    @Expose
    var day: Double? = null

    @Expose
    var eve: Double? = null

    @Expose
    var max: Double? = null

    @Expose
    var min: Double? = null

    @Expose
    var morn: Double? = null

    @Expose
    var night: Double? = null

    class Builder {
        private var day: Double? = null
        private var eve: Double? = null
        private var max: Double? = null
        private var min: Double? = null
        private var morn: Double? = null
        private var night: Double? = null
        fun withDay(day: Double?): Temp.Builder {
            this.day = day
            return this
        }

        fun withEve(eve: Double?): Temp.Builder {
            this.eve = eve
            return this
        }

        fun withMax(max: Double?): Temp.Builder {
            this.max = max
            return this
        }

        fun withMin(min: Double?): Temp.Builder {
            this.min = min
            return this
        }

        fun withMorn(morn: Double?): Temp.Builder {
            this.morn = morn
            return this
        }

        fun withNight(night: Double?): Temp.Builder {
            this.night = night
            return this
        }

        fun build(): Temp {
            var temp: Temp =
                Temp()
            temp.day = day
            temp.eve = eve
            temp.max = max
            temp.min = min
            temp.morn = morn
            temp.night = night
            return temp
        }
    }
}