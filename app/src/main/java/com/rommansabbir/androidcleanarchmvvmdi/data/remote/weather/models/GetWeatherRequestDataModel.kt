package com.rommansabbir.androidcleanarchmvvmdi.data.remote.weather.models

import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.SOMETHING_WENT_WRONG
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.WeatherFailure
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either

class GetWeatherRequestDataModel private constructor(
    val location: String,
    val apiKey: String
) {
    /**
     * We are using [Builder] pattern to generate [GetWeatherRequestDataModel] instance
     * since we might collection multiple name of City for weather report.
     */
    class Builder {
        private var apiKeyWeather: String = ""
        private var locationsList: MutableList<String> = mutableListOf()

        /**
         * Set location
         *
         * @param location, Name of the city in [String]
         * @return [Builder]
         */
        fun withLocation(location: String): Builder {
            if (!locationsList.contains(location)) {
                locationsList.add(location)
            }
            return this
        }

        /**
         * Set API key
         *
         * @param apiKey, [String]
         * @return [Builder]
         */
        fun withAPIKey(apiKey: String): Builder {
            this.apiKeyWeather = apiKey
            return this
        }

        fun build(): Either<Failure, GetWeatherRequestDataModel> {
            try {
                //If API key is empty, throw Failure
                if (apiKeyWeather.isEmpty()) {
                    return Either.Left(WeatherFailure.InvalidAPIKey())
                }
                //If location list is empty, throw Failure
                if (locationsList.isEmpty()) {
                    return Either.Left(WeatherFailure.InvalidRequest())
                }
                //Extract the location from the list
                var location = ""
                if (locationsList.size < 1) {
                    location = locationsList[0]
                } else {
                    locationsList.forEach {
                        location = if (location.isEmpty()) {
                            it
                        } else {
                            "${location},${it}"
                        }
                    }
                }
                return Either.Right(GetWeatherRequestDataModel(location, apiKeyWeather))
            } catch (e: Exception) {
                e.printStackTrace()
                return Either.Left(Failure.UnknownError(e.message ?: SOMETHING_WENT_WRONG))
            }
        }
    }
}