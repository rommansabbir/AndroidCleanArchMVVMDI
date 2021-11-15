package com.rommansabbir.androidcleanarchmvvmdi.base.navigator.home

import android.content.Context
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.Navigator
import dagger.hilt.android.qualifiers.ActivityContext

interface HomeNavigator : Navigator {
    fun navigateToHome(@ActivityContext context: Context)
}