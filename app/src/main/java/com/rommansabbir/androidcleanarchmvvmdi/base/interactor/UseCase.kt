package com.rommansabbir.androidcleanarchmvvmdi.base.interactor

import androidx.lifecycle.LifecycleCoroutineScope
import com.rommansabbir.androidcleanarchmvvmdi.base.exception.Failure
import com.rommansabbir.androidcleanarchmvvmdi.base.functional.Either
import kotlinx.coroutines.*

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This abstraction represents an execution unit for different use cases (this means than any use
 * case in the application should implement this contract).
 *
 * By convention each [UseCase] implementation will execute its job in a background thread
 * (kotlin coroutine) and will post the result in the UI thread.
 */
abstract class UseCase<out Type, in Params> where Type : Any {

    private val mainJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + mainJob)

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) =
        uiScope.launch { onResult(withContext(Dispatchers.IO) { run(params) }) }

    operator fun invoke(
        scope: CoroutineScope,
        params: Params,
        onResult: (Either<Failure, Type>) -> Unit = {}
    ) =
        scope.launch { onResult(withContext(Dispatchers.IO) { run(params) }) }

    operator fun invoke(
        scope: LifecycleCoroutineScope,
        params: Params,
        onResult: (Either<Failure, Type>) -> Unit = {}
    ) =
        scope.launch { onResult(withContext(Dispatchers.IO) { run(params) }) }

    fun cancelJob(message: String = "") {
        mainJob.cancel()
    }

    class None
}
