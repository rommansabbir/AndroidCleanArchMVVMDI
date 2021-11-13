package com.rommansabbir.androidcleanarchmvvmdi.base.navigator.auth

import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.Navigator

interface AuthNavigator : Navigator {
    fun navigateToLogin()
    fun navigateToRegister()
}