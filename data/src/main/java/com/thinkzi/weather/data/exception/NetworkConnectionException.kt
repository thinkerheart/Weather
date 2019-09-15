package com.thinkzi.weather.data.exception

/**
 * provide Exception throw by the application when a there is a network connection exception.
 */
class NetworkConnectionException : Exception {

    constructor() : super() {}

    constructor(_cause: Throwable) : super(_cause) {}
}
