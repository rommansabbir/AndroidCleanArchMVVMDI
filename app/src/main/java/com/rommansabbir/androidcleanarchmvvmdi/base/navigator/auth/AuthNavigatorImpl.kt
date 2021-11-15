package com.rommansabbir.androidcleanarchmvvmdi.base.navigator.auth

import android.app.Activity
import android.content.Context
import com.rommansabbir.androidcleanarchmvvmdi.R
import com.rommansabbir.androidcleanarchmvvmdi.base.platforms.BaseActivity
import com.rommansabbir.androidcleanarchmvvmdi.features.auth.AuthActivity
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class AuthNavigatorImpl @Inject constructor() :
    AuthNavigator {
    override fun navigateToAuth(context: Context) {
        try {
            AuthActivity.Factory.startActivity(context as Activity, true, null)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun navigateToLogin(@ActivityContext context: Context) {
        try {
            (context as BaseActivity<*>).navController.navigate(R.id.loginFragment)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun navigateToRegister(@ActivityContext context: Context) {
        try {
            (context as BaseActivity<*>).navController.navigate(R.id.registerFragment)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}