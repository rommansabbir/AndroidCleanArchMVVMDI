package com.rommansabbir.androidcleanarchmvvmdi.features.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserDataModel
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserLoginRequestModel
import com.rommansabbir.androidcleanarchmvvmdi.domain.auth.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {
    fun loginUser(
        request: UserLoginRequestModel,
        onSuccess: (user: UserDataModel) -> Unit,
        onError: (failure: Failure) -> Unit
    ) {
        loginUseCase.invoke(viewModelScope, request) { either ->
            either.either(
                { onError.invoke(it) },
                { onSuccess.invoke(it) }
            )
        }
    }
}