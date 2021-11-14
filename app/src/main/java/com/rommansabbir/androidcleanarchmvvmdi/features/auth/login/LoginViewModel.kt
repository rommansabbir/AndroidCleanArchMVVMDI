package com.rommansabbir.androidcleanarchmvvmdi.features.auth.login

import androidx.lifecycle.ViewModel
import com.rommansabbir.androidcleanarchmvvmdi.domain.auth.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel()