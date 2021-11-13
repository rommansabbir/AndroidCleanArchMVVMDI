package com.rommansabbir.androidcleanarchmvvmdi.features.auth.register

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.rommansabbir.androidcleanarchmvvmdi.R
import com.rommansabbir.androidcleanarchmvvmdi.base.platforms.BaseFragment
import com.rommansabbir.androidcleanarchmvvmdi.databinding.RegisterFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<RegisterFragmentBinding>() {

    private val vm: RegisterViewModel by viewModels()

    private val actions = object : RegisterActions {
        override fun onRegister() {
            
        }

        override fun onLogin() {
            asAuthActivity {
                it.authNavigator.navigateToLogin()
            }
        }

    }


    override val layoutRes: Int
        get() = R.layout.register_fragment

    override fun onCreated(savedInstance: Bundle?) {
        binding.actions = actions
    }

}