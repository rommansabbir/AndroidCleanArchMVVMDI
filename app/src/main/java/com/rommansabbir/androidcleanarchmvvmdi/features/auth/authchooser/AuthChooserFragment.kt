package com.rommansabbir.androidcleanarchmvvmdi.features.auth.authchooser

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.rommansabbir.androidcleanarchmvvmdi.R
import com.rommansabbir.androidcleanarchmvvmdi.base.platforms.BaseAuthFragment
import com.rommansabbir.androidcleanarchmvvmdi.databinding.AuthChooserFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthChooserFragment : BaseAuthFragment<AuthChooserFragmentBinding>() {
    private val vm: AuthChooserViewModel by viewModels()

    private val actionsListener = object : AuthChooserActions {
        override fun onLoginAction() {
            this@AuthChooserFragment.asAuthActivity {
                it.vm.authNavigator.navigateToLogin(it)
            }
        }

        override fun onRegisterAction() {
            this@AuthChooserFragment.asAuthActivity {
                it.vm.authNavigator.navigateToRegister(it)
            }
        }
    }
    override val layoutRes: Int
        get() = R.layout.auth_chooser_fragment

    override fun onCreated(savedInstance: Bundle?) {
        binding.actions = actionsListener
    }

}