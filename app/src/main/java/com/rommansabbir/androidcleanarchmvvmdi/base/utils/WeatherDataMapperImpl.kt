package com.rommansabbir.androidcleanarchmvvmdi.base.utils

import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.SOMETHING_WENT_WRONG
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.models.WeatherResponseDataModel
import com.rommansabbir.androidcleanarchmvvmdi.features.home.WeatherReportAdapter
import javax.inject.Inject

class WeatherDataMapperImpl @Inject constructor() : WeatherDataMapper {
    override suspend fun map(input: WeatherResponseDataModel): Either<Failure, MutableList<WeatherReportAdapter.DataModels.ReportDataModel>> {
        return try {
            val listToReturn = mutableListOf<WeatherReportAdapter.DataModels.ReportDataModel>()
            input.weather?.let { list ->
                list.forEach { weather ->
                    weather.description?.let {
                        listToReturn.add(
                            WeatherReportAdapter.DataModels.ReportDataModel(
                                "Description",
                                it
                            )
                        )
                    }
                }
            }
            input.main?.let {
                listToReturn.add(
                    WeatherReportAdapter.DataModels.ReportDataModel(
                        "Temp",
                        it.temp?.toString() ?: ""
                    )
                )
                listToReturn.add(
                    WeatherReportAdapter.DataModels.ReportDataModel(
                        "Feels Like",
                        it.feelsLike?.toString() ?: ""
                    )
                )
                listToReturn.add(
                    WeatherReportAdapter.DataModels.ReportDataModel(
                        "Temp Min",
                        it.tempMin?.toString() ?: ""
                    )
                )
                listToReturn.add(
                    WeatherReportAdapter.DataModels.ReportDataModel(
                        "Temp Max",
                        it.tempMax?.toString() ?: ""
                    )
                )
                listToReturn.add(
                    WeatherReportAdapter.DataModels.ReportDataModel(
                        "Pressure",
                        it.pressure?.toString() ?: ""
                    )
                )
                listToReturn.add(
                    WeatherReportAdapter.DataModels.ReportDataModel(
                        "Humidity",
                        it.humidity?.toString() ?: ""
                    )
                )
            }
            input.wind?.let {
                listToReturn.add(
                    WeatherReportAdapter.DataModels.ReportDataModel(
                        "Wind Speed",
                        it.speed?.toString() ?: ""
                    )
                )
                listToReturn.add(
                    WeatherReportAdapter.DataModels.ReportDataModel(
                        "Wind Deg",
                        it.deg?.toString() ?: ""
                    )
                )
            }
            input.name?.let {
                listToReturn.add(
                    WeatherReportAdapter.DataModels.ReportDataModel(
                        "Location Name",
                        it
                    )
                )
            }
            Either.Right(listToReturn)
        } catch (e: Exception) {
            e.printStackTrace()
            Either.Left(Failure.UnknownError(e.message ?: SOMETHING_WENT_WRONG))
        }

    }
}