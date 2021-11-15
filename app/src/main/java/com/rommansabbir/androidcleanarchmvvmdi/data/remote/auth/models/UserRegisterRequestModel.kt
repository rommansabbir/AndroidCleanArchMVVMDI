package com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models

class UserRegisterRequestModel : UserLoginRequestModel() {
    var fullName: String = ""
}