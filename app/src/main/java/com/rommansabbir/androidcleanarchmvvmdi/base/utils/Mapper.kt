package com.rommansabbir.androidcleanarchmvvmdi.base.utils

import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either

interface Mapper<INPUT, OUTPUT> {
    suspend fun map(input: INPUT): Either<Failure, OUTPUT>
}