package com.rommansabbir.androidcleanarchmvvmdi.data.remote.auth.models

import com.rommansabbir.storex.StoreAbleObject

data class CachedUser(val user : UserDataModel) : StoreAbleObject()