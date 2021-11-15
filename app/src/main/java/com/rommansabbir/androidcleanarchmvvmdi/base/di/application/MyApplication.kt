package com.rommansabbir.androidcleanarchmvvmdi.base.di.application

import android.app.Application
import com.rommansabbir.networkx.NetworkXConfig
import com.rommansabbir.networkx.NetworkXProvider
import com.rommansabbir.storex.StoreXCore
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        configureNetworkX()
        initStoreX()
    }

    private fun configureNetworkX() {
        val config = NetworkXConfig.Builder()
            .withApplication(this)
            .withEnableSpeedMeter(true)
            .build()
        NetworkXProvider.enable(config)
    }

    private fun initStoreX() {
        StoreXCore.init(this, "CACHED_AUTH").setEncryptionKey(packageName)
    }
}