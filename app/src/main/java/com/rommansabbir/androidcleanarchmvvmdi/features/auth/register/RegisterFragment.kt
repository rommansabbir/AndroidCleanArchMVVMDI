package com.rommansabbir.androidcleanarchmvvmdi.features.auth.register

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.rommansabbir.androidcleanarchmvvmdi.R
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.AuthFailure
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.SOMETHING_WENT_WRONG
import com.rommansabbir.androidcleanarchmvvmdi.base.extensions.showMessage
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either
import com.rommansabbir.androidcleanarchmvvmdi.base.platforms.BaseAuthFragment
import com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models.UserRegisterRequestModel
import com.rommansabbir.androidcleanarchmvvmdi.databinding.RegisterFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseAuthFragment<RegisterFragmentBinding>() {

    private val vm: RegisterViewModel by viewModels()

    private val actions = object : RegisterActions {
        override fun onRegister() {
            validateRequestModel().either(
                {
                    this@RegisterFragment.handleFailure(it)
                },
                { model ->
                    showHideLoading(true)
                    vm.registerNewUser(
                        model,
                        {
                            showHideLoading(false)
                            this@RegisterFragment.context?.showMessage("New User Registered: ${it.username}")
                        },
                        {
                            showHideLoading(false)
                            this@RegisterFragment.handleFailure(it)
                        }
                    )
                }
            )
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

    /**
     * Validate user register request model. This method should return either the correct state
     * or error state
     *
     * @return [Either], Either<Failure, UserRegisterRequestModel>
     */
    private fun validateRequestModel(): Either<Failure, UserRegisterRequestModel> {
        try {
            val userModel = UserRegisterRequestModel().apply {
                this.fullName = binding.rfInputFullName.text.toString()
                this.username = binding.rfInputUserName.text.toString()
                this.password = binding.rfInputPassword.text.toString()
            }
            if (userModel.fullName.isEmpty() || userModel.username.isEmpty() || userModel.password.isEmpty()) {
                return Either.Left(AuthFailure.InvalidUserRegisterModel())
            }
            return Either.Right(userModel)
        } catch (e: Exception) {
            e.printStackTrace()
            return Either.Left(Failure.UnknownError(e.message ?: SOMETHING_WENT_WRONG))
        }
    }

}