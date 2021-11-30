package com.rommansabbir.androidcleanarchmvvmdi.base.service

import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.SOMETHING_WENT_WRONG
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either
import retrofit2.Call
import javax.inject.Inject

class ApiClient @Inject constructor() {
    fun <T, R> request(
        call: Call<T>,
        transform: (T) -> R,
        default: T,
        postRequest: (R) -> Unit = {}
    ): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> {
                    val transformed = transform((response.body() ?: default))
                    postRequest(transformed)
                    Either.Right(transformed)
                }
                false -> Either.Left(
                    getFailureType(
                        response.code()
                    )
                )
            }
        } catch (exception: Throwable) {
            exception.printStackTrace()
            Either.Left(Failure.UnknownError(exception.message ?: SOMETHING_WENT_WRONG))
        }
    }

    private fun getFailureType(httpCode: Int): Failure {
        return when (httpCode) {
            401 -> return Failure.UnauthorizedAccess()
            400 -> return Failure.BadRequest()
            in 402..409 -> return Failure.BadRequest()
            in 500..509 -> return Failure.InternalServerError()
            else -> Failure.InternalServerError()
        }
    }
}