package com.rommansabbir.androidcleanarchmvvmdi.features.auth

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.rommansabbir.androidcleanarchmvvmdi.R
import com.rommansabbir.androidcleanarchmvvmdi.base.platforms.BaseActivity
import com.rommansabbir.androidcleanarchmvvmdi.databinding.ActivityAuthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseActivity<ActivityAuthBinding>() {
    internal val vm: AuthViewModel by viewModels()
    
    override val layoutRes: Int
        get() = R.layout.activity_auth

    override fun onCreated(instance: Bundle?) {
        navController =
            (supportFragmentManager.findFragmentById(R.id.authNavHostFragment) as NavHostFragment).navController
    }
}