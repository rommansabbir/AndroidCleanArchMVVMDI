package com.rommansabbir.androidcleanarchmvvmdi.base.extensions

import android.content.Context
import android.widget.Toast
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either
import com.rommansabbir.networkx.BuildConfig

fun Context.showDebugMessage(msg: String) {
    if (BuildConfig.DEBUG) {
        showToast(msg, false)
    }
}

fun Context.showMessage(msg: String) {
    showToast(msg, false)
}

fun Context.showToast(message: String, shortTime: Boolean) {
    Toast.makeText(this, message, if (shortTime) Toast.LENGTH_SHORT else Toast.LENGTH_LONG).show()
}

fun <T> throwNoInternetFailure(): Either<Failure, T> = Either.Left(Failure.NoInternet())