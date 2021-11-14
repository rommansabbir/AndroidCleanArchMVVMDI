package com.rommansabbir.androidcleanarchmvvmdi.base.di.modules

import android.content.Context
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.auth.AuthNavigator
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.auth.AuthNavigatorImpl
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.home.HomeNavigator
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.home.HomeNavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ActivityComponent::class)
object NavigatorModule {
    @Provides
    fun provideAuthNavigator(@ActivityContext context: Context): AuthNavigator =
        AuthNavigatorImpl(context)

    @Provides
    fun provideHomeNavigator(@ActivityContext context: Context): HomeNavigator =
        HomeNavigatorImpl(context)
}