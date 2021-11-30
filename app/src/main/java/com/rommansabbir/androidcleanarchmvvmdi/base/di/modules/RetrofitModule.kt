package com.rommansabbir.androidcleanarchmvvmdi.base.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rommansabbir.androidcleanarchmvvmdi.base.di.modules.RetrofitModule.TAGs.AUTH_RETROFIT
import com.rommansabbir.androidcleanarchmvvmdi.base.di.modules.RetrofitModule.TAGs.WEATHER_RETROFIT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    object TAGs {
        /*
        Tags are to identify which retrofit instance should provide to it's clients since we
        will use multiple retrofit instance for this project
         */
        const val AUTH_RETROFIT = "AuthRetrofit"
        const val WEATHER_RETROFIT = "WeatherRetrofit"
    }

    private const val AUTH_BASE_URL = "https://api.localhost.com/auth/"
    private const val WEATHER_BASE_URL = "https://api.openweathermap.org/"

    @Provides
    @Named(AUTH_RETROFIT) //Important step
    fun provideAuthRetrofit(): Retrofit {
        return getNewInstance(AUTH_BASE_URL)
    }

    @Provides
    @Named(WEATHER_RETROFIT) //Important step
    fun provideWeatherRetrofit(): Retrofit {
        return getNewInstance(WEATHER_BASE_URL)
    }

    private val gson: Gson by lazy {
        GsonBuilder()
            .setLenient()
            .serializeNulls()
            .create()
    }

    private val loggingInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val myHttpClient: OkHttpClient by lazy {
        OkHttpClient().newBuilder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(loggingInterceptor)
            .retryOnConnectionFailure(true)
            .build()
    }

    private fun getNewInstance(url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(myHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}