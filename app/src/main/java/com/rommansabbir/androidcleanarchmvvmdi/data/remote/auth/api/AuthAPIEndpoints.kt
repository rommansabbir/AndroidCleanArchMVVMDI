package com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.api

import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserDataModel
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthAPIEndpoints {
    @Headers("Content-Type: application/json")
    @POST("/login/")
    fun login(
        @Query("username") userName: String,
        @Query("password") password: String
    ): Call<UserDataModel>

    @Headers("Content-Type: application/json")
    @POST("/register/")
    fun register(
        @Query("fullName") fullName: String,
        @Query("username") userName: String,
        @Query("password") password: String
    ): Call<UserDataModel>
}