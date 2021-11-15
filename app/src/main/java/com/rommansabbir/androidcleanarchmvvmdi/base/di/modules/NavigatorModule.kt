package com.rommansabbir.androidcleanarchmvvmdi.base.di.modules

import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.auth.AuthNavigator
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.auth.AuthNavigatorImpl
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.home.HomeNavigator
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.home.HomeNavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object NavigatorModule {
    @Provides
    fun provideAuthNavigator(): AuthNavigator =
        AuthNavigatorImpl()

    @Provides
    fun provideHomeNavigator(): HomeNavigator =
        HomeNavigatorImpl()
}