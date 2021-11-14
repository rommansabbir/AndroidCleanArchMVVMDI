package com.rommansabbir.androidcleanarchmvvmdi.base.exception.handler

import android.content.Context
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.AppFailure
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.AuthFailure
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.SOMETHING_WENT_WRONG
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
                is AuthFailure.InvalidUserRegisterModel -> context.showMessage(failure.message)
                is Failure.UnauthorizedAccess -> context.showMessage(failure.message)
                is AuthFailure.LoginFailure -> context.showMessage(failure.message)
                is AppFailure.GenericError -> context.showMessage(failure.message)
                else -> context.showMessage(SOMETHING_WENT_WRONG)
            }
        } catch (e: Exception) {
            context.showMessage(e.message.toString())
        }
    }
}