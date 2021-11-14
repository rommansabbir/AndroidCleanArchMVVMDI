package com.rommansabbir.androidcleanarchmvvmdi.base.di.modules

import com.rommansabbir.androidcleanarchmvvmdi.base.service.ApiClient
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.api.AuthAPIService
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.repository.AuthRepository
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.repository.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    fun provideAuthRepository(apiClient: ApiClient, service: AuthAPIService): AuthRepository =
        AuthRepositoryImpl(apiClient, service)
}