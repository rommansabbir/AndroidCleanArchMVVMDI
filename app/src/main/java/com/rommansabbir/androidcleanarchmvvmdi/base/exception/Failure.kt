package com.rommansabbir.androidcleanarchmvvmdi.base.exception



const val SOMETHING_WENT_WRONG = "Something went wrong."
const val NO_INTERNET = "Device is not connected to the internet."

/**
 * This class represent the app failure, [Failure] should be used across the application
 */
sealed class Failure {
    class UnauthorizedAccess(val message: String = "Unauthorized Access") : Failure()
    class BadRequest(val message: String = "Bad Request") : Failure()
    class UnknownError(var message: String = SOMETHING_WENT_WRONG) : Failure()
    class NoInternet(var message: String = NO_INTERNET) : Failure()
    class GenericError(var message: String) : Failure()
    class InternalServerError(val message: String = "Internal server error"): Failure()
}

