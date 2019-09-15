package com.thinkzi.weather.data.executor

import com.thinkzi.weather.domain.executor.ThreadExecutor

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

import javax.inject.Inject
import javax.inject.Singleton

/**
 * provide an implementation of ThreadExecutor for thread pool to execute works
 */
@Singleton
class JobExecutor @Inject
internal constructor() : ThreadExecutor {

    private val _threadPoolExecutor: ThreadPoolExecutor

    init {
        this._threadPoolExecutor = ThreadPoolExecutor(
            3,
            5,
            10,
            TimeUnit.SECONDS,
            LinkedBlockingQueue(),
            JobThreadFactory()
        )
    }

    override fun execute(command: Runnable) {
        this._threadPoolExecutor.execute(command)
    }

    private class JobThreadFactory : ThreadFactory {
        private var counter = 0


        override fun newThread(r: Runnable): Thread {
            return Thread(r, "android_" + counter++)
        }
    }

}
