package com.thinkzi.weather.domain.usecase.base

import com.thinkzi.weather.domain.executor.PostExecutionThread
import com.thinkzi.weather.domain.executor.ThreadExecutor
import com.thinkzi.weather.domain.utility.check.Checker

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * provide common abstract execution of all reactive asynchronous UseCase(Clean Architecture)
 */
abstract class AsynchronousRxUseCase internal constructor(// executor thread pool to execute work
    internal val _threadExecutor: ThreadExecutor, // thread created to change the execution context
    internal val _postExecutionThread: PostExecutionThread
) {

    // observer set for work result
    private val _compositeDisposables: CompositeDisposable

    init {
        this._compositeDisposables = CompositeDisposable()

    }

    /**
     * dispose all observers
     */
    fun dispose() {

        if (!_compositeDisposables.isDisposed) {

            _compositeDisposables.dispose()

        }

    }

    /**
     * add a observer
     */
    internal fun addDisposable(_disposable: Disposable) {

        Checker.checkNotNull(_disposable)
        Checker.checkNotNull(_compositeDisposables)

        _compositeDisposables.add(_disposable)

    }
}
