package com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather

import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.SOMETHING_WENT_WRONG
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either
import com.rommansabbir.androidcleanarchmvvmdi.base.service.ApiClient
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.api.WeatherAPIService
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.models.GetWeatherRequestDataModel
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.models.WeatherResponseDataModel
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient,
    private val service: WeatherAPIService
) : WeatherRepository {
    override suspend fun getWeather(request: GetWeatherRequestDataModel): Either<Failure, WeatherResponseDataModel> {
        return try {
            apiClient.request(
                service.getWeather(request.location, request.apiKey),
                { it },
                WeatherResponseDataModel()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Either.Left(Failure.UnknownError(e.message ?: SOMETHING_WENT_WRONG))
        }
    }
}