package com.rommansabbir.androidcleanarchmvvmdi.features

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.rommansabbir.androidcleanarchmvvmdi.R
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.AuthFailure
import com.rommansabbir.androidcleanarchmvvmdi.base.platforms.BaseActivity
import com.rommansabbir.androidcleanarchmvvmdi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val vm: MainViewModel by viewModels()

    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun onCreated(instance: Bundle?) {
        lifecycleScope.launch {
            delay(3000)
            vm.isUserAuthenticated(
                {
                    vm.homeNavigator.navigateToHome(this@MainActivity)
                },
                {
                    /*
                    If any failure event occur, we can just start auth section you might wanna
                    check for some business logic based failure, this is just for mock.
                     */
                    if (it is AuthFailure.NoAuthenticatedUserFound) {
                        vm.authNavigator.navigateToAuth(this@MainActivity)
                    } else {
                        handleFailure(it)
                        vm.authNavigator.navigateToAuth(this@MainActivity)
                    }
                }
            )
        }
    }

}