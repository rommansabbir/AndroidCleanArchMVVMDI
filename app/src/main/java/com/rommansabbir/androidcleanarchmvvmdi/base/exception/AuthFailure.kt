package com.rommansabbir.androidcleanarchmvvmdi.base.exception

/**
 * To manage feature specific failures
 */
sealed class AuthFailure : AppFailure() {
    class LoginFailure(val message: String = "Wrong username/password") : AuthFailure()
    class RegisterFailure(val message: String = "Failed to register as a new user") : AuthFailure()
    class InvalidUserRegister(val message: String = "Invalid user register data model") : AuthFailure()
    class InvalidUserLogin(val message: String = "Invalid user login model") : AuthFailure()
}