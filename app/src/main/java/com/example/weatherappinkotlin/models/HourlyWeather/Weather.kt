package com.example.weatherappinkotlin.models.HourlyWeather

import com.google.gson.annotations.Expose

class Weather {
    @Expose
    var description: String? = null
        private set

    @Expose
    var icon: String? = null
        private set

    @Expose
    var id: Long? = null
        private set

    @Expose
    var main: String? = null
        private set

    class Builder {
        private var description: String? = null
        private var icon: String? = null
        private var id: Long? = null
        private var main: String? = null
        fun withDescription(description: String?): Builder {
            this.description = description
            return this
        }

        fun withIcon(icon: String?): Builder {
            this.icon = icon
            return this
        }

        fun withId(id: Long?): Builder {
            this.id = id
            return this
        }

        fun withMain(main: String?): Builder {
            this.main = main
            return this
        }

        fun build(): Weather {
            val weather = Weather()
            weather.description = description
            weather.icon = icon
            weather.id = id
            weather.main = main
            return weather
        }
    }
}