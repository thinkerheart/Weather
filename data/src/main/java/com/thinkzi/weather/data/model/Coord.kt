package com.thinkzi.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Coord {

    @SerializedName("lat")
    @Expose
    var lat: Double = 0.0
    @SerializedName("lon")
    @Expose
    var lon: Double = 0.0

    init {
        this.lat = 0.0
        this.lon = 0.0

    }

}
