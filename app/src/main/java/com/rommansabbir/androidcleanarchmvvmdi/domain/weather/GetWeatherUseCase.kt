package com.rommansabbir.androidcleanarchmvvmdi.domain.weather

import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either
import com.rommansabbir.androidcleanarchmvvmdi.base.interactor.UseCase
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.WeatherRepository
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.models.GetWeatherRequestDataModel
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.models.WeatherResponseDataModel
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(private val repository: WeatherRepository) :
    UseCase<WeatherResponseDataModel, GetWeatherRequestDataModel>() {
    override suspend fun run(params: GetWeatherRequestDataModel): Either<Failure, WeatherResponseDataModel> =
        repository.getWeather(params)
}