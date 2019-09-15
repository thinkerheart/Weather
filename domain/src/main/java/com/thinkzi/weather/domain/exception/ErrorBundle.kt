package com.thinkzi.weather.domain.exception

/**
 * provide Interface to represent a wrapper around an Exception to manage errors
 */
interface ErrorBundle {

    val exception: Exception

    val errorMessage: String

}
