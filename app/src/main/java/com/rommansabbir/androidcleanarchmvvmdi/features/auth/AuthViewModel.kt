package com.rommansabbir.androidcleanarchmvvmdi.features.auth

import androidx.lifecycle.ViewModel
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.auth.AuthNavigator
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.home.HomeNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(internal val authNavigator: AuthNavigator, internal val homeNavigator: HomeNavigator) : ViewModel()