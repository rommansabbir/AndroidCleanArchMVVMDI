package com.rommansabbir.androidcleanarchmvvmdi.features.auth.login

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.rommansabbir.androidcleanarchmvvmdi.R
import com.rommansabbir.androidcleanarchmvvmdi.base.platforms.BaseAuthFragment
import com.rommansabbir.androidcleanarchmvvmdi.base.platforms.BaseFragment
import com.rommansabbir.androidcleanarchmvvmdi.databinding.LoginFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseAuthFragment<LoginFragmentBinding>() {
    private val vm: LoginViewModel by viewModels()

    private val actions = object : LoginActions {
        override fun loginUser() {

        }
    }
    override val layoutRes: Int
        get() = R.layout.login_fragment

    override fun onCreated(savedInstance: Bundle?) {
        binding.actions = actions
    }

}