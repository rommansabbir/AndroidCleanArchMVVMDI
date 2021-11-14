package com.rommansabbir.androidcleanarchmvvmdi.domain.auth

import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either
import com.rommansabbir.androidcleanarchmvvmdi.base.interactor.UseCase
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserDataModel
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.repository.AuthRepository
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserLoginRequestModel
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) : UseCase<UserDataModel, UserLoginRequestModel>() {
    override suspend fun run(params: UserLoginRequestModel): Either<Failure, UserDataModel> = authRepository.loginUser(params)
}