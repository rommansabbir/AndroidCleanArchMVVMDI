package com.rommansabbir.androidcleanarchmvvmdi.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.interactor.UseCase
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.auth.AuthNavigator
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.home.HomeNavigator
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserDataModel
import com.rommansabbir.androidcleanarchmvvmdi.domain.auth.IsUserAuthenticatedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val isUserAuthenticatedUseCase: IsUserAuthenticatedUseCase,internal val homeNavigator: HomeNavigator, internal val authNavigator: AuthNavigator) :
    ViewModel() {
    fun isUserAuthenticated(
        onSuccess: (user: UserDataModel) -> Unit,
        onError: (failure: Failure) -> Unit
    ) {
        isUserAuthenticatedUseCase.invoke(viewModelScope, UseCase.None()) { either ->
            either.either(
                { onError.invoke(it) }, { onSuccess.invoke(it) }
            )
        }
    }
}