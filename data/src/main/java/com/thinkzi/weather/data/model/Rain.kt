package com.thinkzi.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Rain {

    @SerializedName("rainVolume")
    @Expose
    internal var rainVolume: Double = 0.toDouble()

    init {
        this.rainVolume = 0.0
    }

    fun getRainVolume(): Double {
        return rainVolume
    }

    fun setRainVolume(_rainVolume: Double) {
        this.rainVolume = _rainVolume
    }

}
