package com.thinkzi.weather.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.thinkzi.weather.domain.exception.DefaultErrorBundle

/**
 * provide BaseViewModel for operations: save data of View(Activity) for configuration change management,
 * treat actions from View, data binding, live data, observer result sent from UseCase ...
 */
abstract class BaseViewModel protected constructor() : ViewModel() {

    // default error bundle to receive error in live data from a result of UseCase
    var defaultErrorBundleMutableLiveData: MutableLiveData<DefaultErrorBundle>
        protected set

    init {
        defaultErrorBundleMutableLiveData = MutableLiveData()
    }

    /**
     * handle received error in live data from a result of UseCase
     */
    protected fun handleError(_defaultErrorBundle: DefaultErrorBundle) {

        defaultErrorBundleMutableLiveData.value = _defaultErrorBundle

    }

}
