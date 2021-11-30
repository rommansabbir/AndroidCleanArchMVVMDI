package com.rommansabbir.androidcleanarchmvvmdi.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.models.GetWeatherRequestDataModel
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.models.WeatherResponseDataModel
import com.rommansabbir.androidcleanarchmvvmdi.domain.mapper.WeatherDataToReportDataMapperUseCase
import com.rommansabbir.androidcleanarchmvvmdi.domain.weather.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val mapper: WeatherDataToReportDataMapperUseCase
) :
    ViewModel() {

    val getMapper: WeatherDataToReportDataMapperUseCase
        get() = mapper

    fun getWeatherReport(
        request: GetWeatherRequestDataModel,
        onSuccess: (response: WeatherResponseDataModel) -> Unit,
        onError: (failure: Failure) -> Unit
    ) {
        getWeatherUseCase.invoke(viewModelScope, request) { either ->
            either.either({ onError.invoke(it) }, { onSuccess.invoke(it) })
        }
    }
}