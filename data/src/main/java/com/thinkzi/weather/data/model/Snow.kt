package com.thinkzi.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Snow {

    @SerializedName("snowVolume")
    @Expose
    internal var snowVolume: Double = 0.toDouble()

    init {
        this.snowVolume = 0.0
    }

    fun getSnowVolume(): Double {
        return snowVolume
    }

    fun setSnowVolume(_snowVolume: Double) {
        this.snowVolume = _snowVolume
    }
}
