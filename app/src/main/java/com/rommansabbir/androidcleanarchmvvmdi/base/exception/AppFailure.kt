package com.rommansabbir.androidcleanarchmvvmdi.base.exception

/**
 * To manage app level failures
 */
sealed class AppFailure : Failure() {
    class GenericError(val message: String = "Just a random error")
}

