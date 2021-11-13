package com.rommansabbir.androidcleanarchmvvmdi.base.di.modules

import android.content.Context
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.handler.FailureHandler
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.handler.FailureHandlerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {
    @Provides
    fun provideFailureHandler(@ActivityContext context: Context): FailureHandler =
        FailureHandlerImpl(context)
}