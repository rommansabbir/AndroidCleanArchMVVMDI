package com.rommansabbir.androidcleanarchmvvmdi.domain.auth

import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either
import com.rommansabbir.androidcleanarchmvvmdi.base.interactor.UseCase
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserDataModel
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.repository.AuthRepository
import javax.inject.Inject

class IsUserAuthenticatedUseCase @Inject constructor(private val repo: AuthRepository) :
    UseCase<UserDataModel, UseCase.None>() {
    override suspend fun run(params: None): Either<Failure, UserDataModel> = repo.isAuthenticated()
}