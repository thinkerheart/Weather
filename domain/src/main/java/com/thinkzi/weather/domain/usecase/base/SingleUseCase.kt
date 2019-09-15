package com.thinkzi.weather.domain.usecase.base

import com.thinkzi.weather.domain.executor.PostExecutionThread
import com.thinkzi.weather.domain.executor.ThreadExecutor
import com.thinkzi.weather.domain.utility.check.Checker

import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/**
 * provide common abstract execution of all reactive asynchronous UseCase(Clean Architecture) that have only results (return only Rs object or error)
 */
abstract class SingleUseCase<Rs, Ps> protected constructor(
    _threadExecutor: ThreadExecutor,
    _postExecutionThread: PostExecutionThread
) : AsynchronousRxUseCase(_threadExecutor, _postExecutionThread) {

    /**
     * build work execution of UseCase
     */
    protected abstract fun buildSingleUseCase(_params: Ps): Single<Rs>

    /**
     * add observer for result and execute UseCase with input parameter
     */
    fun execute(_observer: DisposableSingleObserver<Rs>, _params: Ps) {

        Checker.checkNotNull(_observer)

        val _single = this.buildSingleUseCase(_params)
            .subscribeOn(Schedulers.from(_threadExecutor))
            .observeOn(_postExecutionThread.scheduler)

        addDisposable(_single.subscribeWith(_observer))

    }
}
