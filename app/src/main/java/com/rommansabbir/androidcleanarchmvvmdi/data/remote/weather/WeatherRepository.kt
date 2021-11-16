package com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather

import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.models.GetWeatherRequestDataModel
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.models.WeatherResponseDataModel

interface WeatherRepository {
    suspend fun getWeather(request : GetWeatherRequestDataModel): Either<Failure, WeatherResponseDataModel>
}