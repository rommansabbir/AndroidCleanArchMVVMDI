package com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.api

import com.rommansabbir.androidcleanarchmvvmdi.base.di.modules.RetrofitModule
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.models.WeatherResponseDataModel
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

class WeatherAPIService @Inject constructor(@Named(RetrofitModule.TAGs.WEATHER_RETROFIT) private val retrofit: Retrofit) :
    WeatherAPIEndpoints {
    private val api by lazy { retrofit.create(WeatherAPIEndpoints::class.java) }

    override fun getWeather(q: String, appid: String): Call<WeatherResponseDataModel> =
        api.getWeather(q, appid)
}