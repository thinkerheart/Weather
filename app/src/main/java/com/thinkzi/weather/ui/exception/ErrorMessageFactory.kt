package com.thinkzi.weather.ui.exception

import android.content.Context

import com.thinkzi.weather.data.exception.NetworkConnectionException
import com.thinkzi.weather.ui.R

/**
 * provide Factory used to create error messages from an Exception as a condition.
 */
object ErrorMessageFactory {

    /**
     * creates a String representing an error message.
     */
    fun create(_context: Context, _exception: Exception): String {

        var _message = _context.getString(R.string.exception_message_generic)

        if (_exception is NetworkConnectionException) {
            _message = _context.getString(R.string.exception_message_no_connection)
        }

        return _message

    }

}
