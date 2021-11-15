package com.rommansabbir.androidcleanarchmvvmdi.domain.auth

import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either
import com.rommansabbir.androidcleanarchmvvmdi.base.interactor.UseCase
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserDataModel
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.repository.AuthRepository
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserRegisterRequestModel
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val authRepository: AuthRepository) :
    UseCase<UserDataModel, UserRegisterRequestModel>() {
    override suspend fun run(params: UserRegisterRequestModel): Either<Failure, UserDataModel> =
        authRepository.registerUser(params)
}