package com.rommansabbir.androidcleanarchmvvmdi.features.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserDataModel
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserRegisterRequestModel
import com.rommansabbir.androidcleanarchmvvmdi.domain.auth.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val registerUseCase: RegisterUseCase) :
    ViewModel() {
    fun registerNewUser(
        user: UserRegisterRequestModel,
        onSuccess: (user: UserDataModel) -> Unit,
        onError: (failure: Failure) -> Unit
    ) {
        registerUseCase.invoke(viewModelScope, user) { either ->
            either.either(
                { onError.invoke(it) },
                { onSuccess.invoke(it) }
            )
        }
    }
}