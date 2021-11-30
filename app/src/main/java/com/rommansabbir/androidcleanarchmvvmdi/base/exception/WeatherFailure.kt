package com.rommansabbir.androidcleanarchmvvmdi.base.exception

sealed class WeatherFailure : Failure(){
    class InvalidRequest(val message : String = "Invalid get request"): WeatherFailure()
    class InvalidAPIKey(val message : String = "Invalid API key"): WeatherFailure()
}