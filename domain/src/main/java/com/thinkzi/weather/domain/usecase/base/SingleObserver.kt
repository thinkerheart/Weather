package com.thinkzi.weather.domain.usecase.base

import io.reactivex.observers.DisposableSingleObserver

/**
 * provide a observer for the work result (returned only T object or error)
 */
open class SingleObserver<T> : DisposableSingleObserver<T>() {

    override fun onSuccess(t: T) {

    }

    override fun onError(e: Throwable) {

    }

}
