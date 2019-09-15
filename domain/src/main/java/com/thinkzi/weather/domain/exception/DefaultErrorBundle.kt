package com.thinkzi.weather.domain.exception

/**
 * provide Wrapper around Exceptions used to manage default errors
 */
class DefaultErrorBundle(private val _exception: Exception) : ErrorBundle {
    override val exception: Exception
        get() = _exception
    override val errorMessage: String
        get() = this._exception.message!!

    companion object {

        private val DEFAULT_ERROR_MSG = "Unknown error"
    }

}
