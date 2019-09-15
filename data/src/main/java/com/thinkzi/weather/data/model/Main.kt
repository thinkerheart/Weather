package com.thinkzi.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Main {

    @SerializedName("temp")
    @Expose
    var temp: Double = 0.0
    @SerializedName("temp_min")
    @Expose
    var tempMin: Double = 0.0
    @SerializedName("temp_max")
    @Expose
    var tempMax: Double = 0.0
    @SerializedName("pressure")
    @Expose
    var pressure: Double = 0.0
    @SerializedName("sea_level")
    @Expose
    var seaLevel: Double = 0.0
    @SerializedName("grnd_level")
    @Expose
    var grndLevel: Double = 0.0
    @SerializedName("humidity")
    @Expose
    var humidity: Int = 0
    @SerializedName("temp_kf")
    @Expose
    var tempKf: Double = 0.0

    init {
        this.temp = 0.0
        this.tempMax = 0.0
        this.tempMin = 0.0
        this.pressure = 0.0
        this.seaLevel = 0.0
        this.grndLevel = 0.0
        this.humidity = 0
        this.tempKf = 0.0
    }

}
