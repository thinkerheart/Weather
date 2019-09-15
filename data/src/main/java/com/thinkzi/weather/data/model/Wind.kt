package com.thinkzi.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Wind {

    @SerializedName("speed")
    @Expose
    var speed: Double = 0.0
    @SerializedName("deg")
    @Expose
    var deg: Double = 0.0

    init {
        this.speed = 0.0
        this.deg = 0.0
    }

}
