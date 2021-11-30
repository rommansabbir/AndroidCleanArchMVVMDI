package com.rommansabbir.androidcleanarchmvvmdi

import android.os.Bundle
import androidx.activity.viewModels
import com.rommansabbir.androidcleanarchmvvmdi.base.platforms.BaseActivity
import com.rommansabbir.androidcleanarchmvvmdi.databinding.ActivityMainBinding
import com.rommansabbir.androidcleanarchmvvmdi.features.auth.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val vm: AuthViewModel by viewModels()
    
    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun onCreated(instance: Bundle?) {

    }

}