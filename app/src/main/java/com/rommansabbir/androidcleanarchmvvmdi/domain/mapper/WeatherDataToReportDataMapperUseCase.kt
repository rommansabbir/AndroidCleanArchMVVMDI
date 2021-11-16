package com.rommansabbir.androidcleanarchmvvmdi.domain.mapper

import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either
import com.rommansabbir.androidcleanarchmvvmdi.base.interactor.UseCase
import com.rommansabbir.androidcleanarchmvvmdi.base.utils.WeatherDataMapper
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.models.WeatherResponseDataModel
import com.rommansabbir.androidcleanarchmvvmdi.features.home.WeatherReportAdapter
import javax.inject.Inject

class WeatherDataToReportDataMapperUseCase @Inject constructor(private val mapper: WeatherDataMapper) :
    UseCase<MutableList<WeatherReportAdapter.DataModels.ReportDataModel>, WeatherResponseDataModel>() {
    override suspend fun run(params: WeatherResponseDataModel): Either<Failure, MutableList<WeatherReportAdapter.DataModels.ReportDataModel>> =
        mapper.map(params)
}