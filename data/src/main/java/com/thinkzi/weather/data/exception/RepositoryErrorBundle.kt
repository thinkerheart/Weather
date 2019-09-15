package com.thinkzi.weather.data.exception

import com.thinkzi.weather.domain.exception.ErrorBundle

/**
 * provide Wrapper around Exceptions used to manage errors in the repository.
 */
class RepositoryErrorBundle(override val exception: Exception) : ErrorBundle {

    override val errorMessage: String
        get() {
            var _message: String = this.exception.message!!

            return _message
        }

}
