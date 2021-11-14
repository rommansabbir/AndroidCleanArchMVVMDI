package com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.repository

import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserDataModel
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserLoginRequestModel
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserRegisterRequestModel

interface AuthRepository {
    suspend fun loginUser(request: UserLoginRequestModel): Either<Failure, UserDataModel>
    suspend fun registerUser(request: UserRegisterRequestModel): Either<Failure, UserDataModel>
}