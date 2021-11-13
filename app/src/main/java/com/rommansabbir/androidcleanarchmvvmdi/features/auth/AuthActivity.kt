package com.rommansabbir.androidcleanarchmvvmdi.features.auth

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import com.rommansabbir.androidcleanarchmvvmdi.R
import com.rommansabbir.androidcleanarchmvvmdi.base.navigator.auth.AuthNavigator
import com.rommansabbir.androidcleanarchmvvmdi.base.platforms.BaseActivity
import com.rommansabbir.androidcleanarchmvvmdi.databinding.ActivityAuthBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AuthActivity : BaseActivity<ActivityAuthBinding>() {
    @Inject
    lateinit var authNavigator: AuthNavigator

    private val vm: AuthViewModel by viewModels()

    override val layoutRes: Int
        get() = R.layout.activity_auth

    override fun onCreated(instance: Bundle?) {
        navController = findNavController(R.id.authNavHostFragment)
    }
}