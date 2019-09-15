package com.thinkzi.weather.domain.usecase.base

/**
 * provide common execution interface of all synchronous UseCase(Clean Architecture)
 */
interface SynchronousUseCase<Rs, Ps> {

    interface Callback<Rs> {

        fun onSuccess(_return: Rs)

        fun onError(_throwable: Throwable)

    }

    fun execute(_parameter: Ps, _callback: Callback<Rs>)

}
