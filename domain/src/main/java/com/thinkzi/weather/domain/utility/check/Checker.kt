package com.thinkzi.weather.domain.utility.check

/**
 * provide some data checks
 */
object Checker {

    /**
     * check not null T object
     */
    fun <T> checkNotNull(_objectReference: T?): T {

        if (_objectReference == null) {

            throw NullPointerException()

        }

        return _objectReference

    }

}
