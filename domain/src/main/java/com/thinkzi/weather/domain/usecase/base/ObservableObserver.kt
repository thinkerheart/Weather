package com.thinkzi.weather.domain.usecase.base

import io.reactivex.observers.DisposableObserver

/**
 * provide a observer for the work result (T object or complete or error)
 */
class ObservableObserver<T> : DisposableObserver<T>() {

    override fun onNext(t: T) {

    }

    override fun onError(e: Throwable) {

    }

    override fun onComplete() {

    }

}
