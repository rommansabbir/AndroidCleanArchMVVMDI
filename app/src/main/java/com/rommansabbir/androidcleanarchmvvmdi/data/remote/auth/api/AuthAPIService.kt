package com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.api

import com.rommansabbir.androidcleanarchmvvmdi.base.di.modules.RetrofitModule
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserDataModel
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

class AuthAPIService @Inject constructor(@Named(RetrofitModule.TAGs.AUTH_RETROFIT) private val retrofit: Retrofit) :
    AuthAPIEndpoints {
    //Lazy initialization
    private val api by lazy { retrofit.create(AuthAPIEndpoints::class.java) }

    override fun login(userName: String, password: String): Call<UserDataModel> =
        api.login(userName, password)

    override fun register(
        fullName: String,
        userName: String,
        password: String
    ): Call<UserDataModel> = api.register(fullName, userName, password)
}