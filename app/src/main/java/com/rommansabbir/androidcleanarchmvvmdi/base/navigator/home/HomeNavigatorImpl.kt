package com.rommansabbir.androidcleanarchmvvmdi.base.navigator.home

import android.app.Activity
import android.content.Context
import com.rommansabbir.androidcleanarchmvvmdi.features.home.HomeActivity
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class HomeNavigatorImpl @Inject constructor(@ActivityContext private val context: Context) :
    HomeNavigator {
    override fun navigateToHome() {
        try {
            HomeActivity.Factory.startActivity(context as Activity, true, null)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}