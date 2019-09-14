package com.thinkzi.weather.domain.executor;

import java.util.concurrent.Executor;

/**
 * provide Executor implementation can be based on different frameworks or techniques of asynchronous
 * execution, but every implementation will execute the
 * {@link com.thinkzi.weather.domain.usecase.base.AsynchronousRxUseCase}
 * {@link com.thinkzi.weather.domain.usecase.base.SynchronousUseCase} out of the UI thread.
 */
public interface ThreadExecutor extends Executor {}

