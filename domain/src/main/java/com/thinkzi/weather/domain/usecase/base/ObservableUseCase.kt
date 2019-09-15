package com.thinkzi.weather.domain.usecase.base

import com.thinkzi.weather.domain.executor.PostExecutionThread
import com.thinkzi.weather.domain.executor.ThreadExecutor
import com.thinkzi.weather.domain.utility.check.Checker

import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * provide common abstract execution of all reactive asynchronous UseCase(Clean Architecture) that have only results (Rs object or complete or error)
 */
abstract class ObservableUseCase<Rs, Ps> protected constructor(
    _threadExecutor: ThreadExecutor,
    _postExecutionThread: PostExecutionThread
) : AsynchronousRxUseCase(_threadExecutor, _postExecutionThread) {

    /**
     * build work execution of UseCase
     */
    protected abstract fun buildObservableUseCase(_params: Ps): Observable<Rs>

    /**
     * add observer for result and execute UseCase with input parameter
     */
    fun execute(_observer: DisposableObserver<Rs>, _params: Ps) {

        Checker.checkNotNull(_observer)

        val _observable = this.buildObservableUseCase(_params)
            .subscribeOn(Schedulers.from(_threadExecutor))
            .observeOn(_postExecutionThread.scheduler)

        addDisposable(_observable.subscribeWith(_observer))

    }

}
