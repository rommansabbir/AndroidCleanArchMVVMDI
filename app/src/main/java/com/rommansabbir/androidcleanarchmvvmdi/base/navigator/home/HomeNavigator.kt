package com.rommansabbir.androidcleanarchmvvmdi.base.navigator.home

import android.content.Context
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.Navigator
import dagger.hilt.android.qualifiers.ActivityContext

/**
 * This is the feature specific navigator.
 * Write down all the possible navigation flow here.
 */
interface HomeNavigator : Navigator {
    fun navigateToHome(@ActivityContext context: Context)
}