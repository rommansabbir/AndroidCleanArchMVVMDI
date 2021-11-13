package com.rommansabbir.androidcleanarchmvvmdi.base.navigator.auth

import android.content.Context
import com.rommansabbir.androidcleanarchmvvmdi.R
import com.rommansabbir.androidcleanarchmvvmdi.base.platforms.BaseActivity
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class AuthNavigatorImpl @Inject constructor(@ActivityContext private val context: Context) :
    AuthNavigator {
    override fun navigateToLogin() {
        (context as BaseActivity<*>).navController.navigate(R.id.action_authChooserFragment_to_loginFragment)
    }

    override fun navigateToRegister() {
        (context as BaseActivity<*>).navController.navigate(R.id.action_authChooserFragment_to_registerFragment)
    }

}