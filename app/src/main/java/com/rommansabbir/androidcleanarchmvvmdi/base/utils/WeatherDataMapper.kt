package com.rommansabbir.androidcleanarchmvvmdi.base.utils

import com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.models.WeatherResponseDataModel
import com.rommansabbir.androidcleanarchmvvmdi.features.home.WeatherReportAdapter

interface WeatherDataMapper :
    Mapper<WeatherResponseDataModel, MutableList<WeatherReportAdapter.DataModels.ReportDataModel>>