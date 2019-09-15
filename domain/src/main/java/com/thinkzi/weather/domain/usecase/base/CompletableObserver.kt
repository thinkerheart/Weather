package com.thinkzi.weather.domain.usecase.base

import io.reactivex.observers.DisposableCompletableObserver

/**
 * provide a observer for the work result (complete or error)
 */
class CompletableObserver : DisposableCompletableObserver() {

    override fun onComplete() {

    }

    override fun onError(e: Throwable) {

    }

}
