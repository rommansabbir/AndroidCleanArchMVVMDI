package com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.repository

import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.SOMETHING_WENT_WRONG
import com.rommansabbir.androidcleanarchmvvmdi.base.extensions.throwNoInternetFailure
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either
import com.rommansabbir.androidcleanarchmvvmdi.base.service.ApiClient
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserDataModel
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.api.AuthAPIService
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserLoginRequestModel
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserRegisterRequestModel
import com.rommansabbir.networkx.NetworkXProvider
import kotlinx.coroutines.delay
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient,
    private val service: AuthAPIService
) : AuthRepository {
    override suspend fun loginUser(request: UserLoginRequestModel): Either<Failure, UserDataModel> {
        return try {
            if (NetworkXProvider.isInternetConnected) {
                // Execute API request, for the demo purpose code will be commented out
                /* apiClient.request(
                    service.login(request.username, request.password),
                    {},
                    UserDataModel()
                ) */

                //Faking request time
                delay(2000)
                Either.Right(UserDataModel().apply {
                    this.username = request.username
                    this.profileImage = "something_url"
                    this.token = "something_token"
                })
            } else {
                return throwNoInternetFailure()
            }
        } catch (e: Exception) {
            Either.Left(Failure.UnknownError(e.message ?: SOMETHING_WENT_WRONG))
        }
    }

    override suspend fun registerUser(request: UserRegisterRequestModel): Either<Failure, UserDataModel> {
        return try {
            if (NetworkXProvider.isInternetConnected) {
                // Execute API request, for the demo purpose code will be commented out
                /* apiClient.request(
                    service.register(request.fullName,request.username, request.password),
                    {},
                    UserDataModel()
                )  */

                //Faking request time
                delay(2000)
                Either.Right(UserDataModel().apply {
                    this.username = request.username
                    this.profileImage = "something_url"
                    this.token = "something_token"
                })
            } else {
                return throwNoInternetFailure()
            }
        } catch (e: Exception) {
            Either.Left(Failure.UnknownError(e.message ?: SOMETHING_WENT_WRONG))
        }
    }
}