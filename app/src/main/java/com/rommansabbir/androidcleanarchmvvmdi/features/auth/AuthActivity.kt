package com.rommansabbir.androidcleanarchmvvmdi.features.auth

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.rommansabbir.androidcleanarchmvvmdi.R
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.auth.AuthNavigator
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.home.HomeNavigator
import com.rommansabbir.androidcleanarchmvvmdi.base.platforms.BaseActivity
import com.rommansabbir.androidcleanarchmvvmdi.databinding.ActivityAuthBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AuthActivity : BaseActivity<ActivityAuthBinding>() {
    @Inject
    lateinit var authNavigator: AuthNavigator

    @Inject
    lateinit var homeNavigator: HomeNavigator

    private val vm: AuthViewModel by viewModels()

    override val layoutRes: Int
        get() = R.layout.activity_auth

    override fun onCreated(instance: Bundle?) {
        navController =
            (supportFragmentManager.findFragmentById(R.id.authNavHostFragment) as NavHostFragment).navController
    }
}