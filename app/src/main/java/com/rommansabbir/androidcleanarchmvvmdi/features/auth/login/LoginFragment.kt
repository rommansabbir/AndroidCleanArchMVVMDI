package com.rommansabbir.androidcleanarchmvvmdi.features.auth.login

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.rommansabbir.androidcleanarchmvvmdi.R
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.AuthFailure
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.SOMETHING_WENT_WRONG
import com.rommansabbir.androidcleanarchmvvmdi.base.extensions.showMessage
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either
import com.rommansabbir.androidcleanarchmvvmdi.base.platforms.BaseAuthFragment
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserLoginRequestModel
import com.rommansabbir.androidcleanarchmvvmdi.databinding.LoginFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseAuthFragment<LoginFragmentBinding>() {
    private val vm: LoginViewModel by viewModels()

    private val actions = object : LoginActions {
        override fun loginUser() {
            validateLoginModel().either(
                { this@LoginFragment.handleFailure(it) },
                { model ->
                    showHideLoading(true)
                    vm.loginUser(
                        model,
                        { dataModel ->
                            showHideLoading(false)
                            this@LoginFragment.context?.showMessage("Logged In: ${dataModel.username}")
                            asAuthActivity {
                                it.homeNavigator.navigateToHome()
                            }
                        },
                        {
                            showHideLoading(false)
                            this@LoginFragment.handleFailure(it)
                        }
                    )
                }
            )
        }

        override fun registerUser() {
            asAuthActivity {
                it.authNavigator.navigateToRegister()
            }
        }
    }
    override val layoutRes: Int
        get() = R.layout.login_fragment

    override fun onCreated(savedInstance: Bundle?) {
        binding.actions = actions
        binding.lifecycleOwner = viewLifecycleOwner
    }

    /**
     * Validate user login request model. This method should return either the correct state
     * or error state
     *
     * @return [Either], Either<Failure, UserLoginRequestModel>
     */
    private fun validateLoginModel(): Either<Failure, UserLoginRequestModel> {
        return try {
            val request = UserLoginRequestModel().apply {
                this.username = binding.lfInputUsername.text.toString()
                this.password = binding.lfInputPassword.text.toString()
            }
            if (request.username.isEmpty() || request.password.isEmpty()) {
                return Either.Left(AuthFailure.InvalidUserLogin())
            }
            return Either.Right(request)
        } catch (e: Exception) {
            Either.Left(Failure.UnknownError(e.message ?: SOMETHING_WENT_WRONG))
        }
    }

}