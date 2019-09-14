package com.thinkzi.weather.domain.exception;

/**
* provide Interface to represent a wrapper around an Exception to manage errors
* */
public interface ErrorBundle {

    Exception getException();

    String getErrorMessage();

}
