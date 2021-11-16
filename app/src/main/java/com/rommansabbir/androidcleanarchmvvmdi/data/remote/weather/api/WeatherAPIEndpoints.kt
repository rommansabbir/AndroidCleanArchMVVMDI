package com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.api

import com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.models.WeatherResponseDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherAPIEndpoints {
    @Headers("Content-Type: application/json")
    @GET("/data/2.5/weather")
    fun getWeather(
        @Query("q", encoded = true) q: String,
        @Query("appid") appid: String
    ): Call<WeatherResponseDataModel>
}