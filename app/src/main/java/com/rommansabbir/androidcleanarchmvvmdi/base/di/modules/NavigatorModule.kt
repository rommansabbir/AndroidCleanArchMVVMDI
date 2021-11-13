package com.rommansabbir.androidcleanarchmvvmdi.base.di.modules

import android.content.Context
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.auth.AuthNavigator
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.auth.AuthNavigatorImpl
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
}