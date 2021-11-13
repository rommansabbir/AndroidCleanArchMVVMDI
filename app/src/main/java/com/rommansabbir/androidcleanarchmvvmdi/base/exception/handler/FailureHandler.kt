package com.rommansabbir.androidcleanarchmvvmdi.base.exception.handler

import android.content.Context
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure

interface FailureHandler {
    fun handleFailure(failure: Failure)
}