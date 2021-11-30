package com.rommansabbir.androidcleanarchmvvmdi.base.utils

import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either

/**
 * This interface stands for mapping specific object to required object
 */
interface Mapper<INPUT, OUTPUT> {
    suspend fun map(input: INPUT): Either<Failure, OUTPUT>
}