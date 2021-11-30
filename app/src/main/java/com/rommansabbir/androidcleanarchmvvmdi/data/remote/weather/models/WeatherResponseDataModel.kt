package com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.models


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WeatherResponseDataModel {
    @SerializedName("coord")
    @Expose
    var coord: InnerObjects.Coord? = null

    @SerializedName("weather")
    @Expose
    var weather: List<InnerObjects.Weather>? = null

    @SerializedName("base")
    @Expose
    var base: String? = null

    @SerializedName("main")
    @Expose
    var main: InnerObjects.Main? = null

    @SerializedName("visibility")
    @Expose
    var visibility: Int? = null

    @SerializedName("wind")
    @Expose
    var wind: InnerObjects.Wind? = null

    @SerializedName("clouds")
    @Expose
    var clouds: InnerObjects.Clouds? = null

    @SerializedName("dt")
    @Expose
    var dt: Int? = null

    @SerializedName("sys")
    @Expose
    var sys: InnerObjects.Sys? = null

    @SerializedName("timezone")
    @Expose
    var timezone: Int? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("cod")
    @Expose
    var cod: Int? = null

    object InnerObjects{
        class Wind {
            @SerializedName("speed")
            @Expose
            var speed: Double? = null

            @SerializedName("deg")
            @Expose
            var deg: Int? = null
        }

        class Weather {
            @SerializedName("id")
            @Expose
            var id: Int? = null

            @SerializedName("main")
            @Expose
            var main: String? = null

            @SerializedName("description")
            @Expose
            var description: String? = null

            @SerializedName("icon")
            @Expose
            var icon: String? = null
        }

        class Sys {
            @SerializedName("type")
            @Expose
            var type: Int? = null

            @SerializedName("id")
            @Expose
            var id: Int? = null

            @SerializedName("country")
            @Expose
            var country: String? = null

            @SerializedName("sunrise")
            @Expose
            var sunrise: Int? = null

            @SerializedName("sunset")
            @Expose
            var sunset: Int? = null
        }

        class Main {
            @SerializedName("temp")
            @Expose
            var temp: Double? = null

            @SerializedName("feels_like")
            @Expose
            var feelsLike: Double? = null

            @SerializedName("temp_min")
            @Expose
            var tempMin: Double? = null

            @SerializedName("temp_max")
            @Expose
            var tempMax: Double? = null

            @SerializedName("pressure")
            @Expose
            var pressure: Int? = null

            @SerializedName("humidity")
            @Expose
            var humidity: Int? = null
        }

        class Coord {
            @SerializedName("lon")
            @Expose
            var lon: Double? = null

            @SerializedName("lat")
            @Expose
            var lat: Double? = null
        }

        class Clouds {
            @SerializedName("all")
            @Expose
            var all: Int? = null
        }
    }
}