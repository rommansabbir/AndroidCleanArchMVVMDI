package com.rommansabbir.androidcleanarchmvvmdi.base.exception.handler

import android.content.Context
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.*
import com.rommansabbir.androidcleanarchmvvmdi.base.extensions.showMessage
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class FailureHandlerImpl @Inject constructor(@ActivityContext private val context: Context) :
    FailureHandler {
    override fun handleFailure(failure: Failure) {
        try {
            when (failure) {
                is Failure.UnknownError -> context.showMessage(failure.message)
                is Failure.NoInternet -> context.showMessage(failure.message)
                is Failure.GenericError -> context.showMessage(failure.message)
                is AuthFailure.RegisterFailure -> context.showMessage(failure.message)
                is AuthFailure.InvalidUserRegister -> context.showMessage(failure.message)
                is AuthFailure.InvalidUserLogin -> context.showMessage(failure.message)
                is AuthFailure.NoAuthenticatedUserFound -> context.showMessage(failure.message)
                is Failure.UnauthorizedAccess -> context.showMessage(failure.message)
                is AuthFailure.LoginFailure -> context.showMessage(failure.message)
                is AppFailure.GenericError -> context.showMessage(failure.message)
                is WeatherFailure.InvalidRequest -> context.showMessage(failure.message)
                is WeatherFailure.InvalidAPIKey -> context.showMessage(failure.message)
                else -> context.showMessage(SOMETHING_WENT_WRONG)
            }
        } catch (e: Exception) {
            context.showMessage(e.message.toString())
        }
    }
}