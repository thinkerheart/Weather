package com.thinkzi.weather.domain.usecase.base

import com.thinkzi.weather.domain.executor.PostExecutionThread
import com.thinkzi.weather.domain.executor.ThreadExecutor
import com.thinkzi.weather.domain.utility.check.Checker

import io.reactivex.Completable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers

/**
 * provide common abstract execution of all reactive asynchronous UseCase(Clean Architecture) that have only 2 results (complete or error)
 */
abstract class CompletableUseCase<Ps> protected constructor(
    _threadExecutor: ThreadExecutor,
    _postExecutionThread: PostExecutionThread
) : AsynchronousRxUseCase(_threadExecutor, _postExecutionThread) {

    /**
     * build work execution of UseCase
     */
    protected abstract fun buildCompletableUseCase(_params: Ps): Completable

    /**
     * add observer for result and execute UseCase with input parameter
     */
    fun execute(_observer: DisposableCompletableObserver, _params: Ps) {

        Checker.checkNotNull(_observer)

        val _completable = this.buildCompletableUseCase(_params)
            .subscribeOn(Schedulers.from(_threadExecutor))
            .observeOn(_postExecutionThread.scheduler)

        addDisposable(_completable.subscribeWith(_observer))

    }
}
