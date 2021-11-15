package com.rommansabbir.androidcleanarchmvvmdi.base.navigator.auth

import android.content.Context
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.Navigator
import dagger.hilt.android.qualifiers.ActivityContext

interface AuthNavigator : Navigator {
    fun navigateToLogin(@ActivityContext context: Context)
    fun navigateToRegister(@ActivityContext context: Context)
}