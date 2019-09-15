package com.thinkzi.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class City {

    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("name")
    @Expose
    var name: String =""
    @SerializedName("coord")
    @Expose
    var coord: Coord = Coord()
    @SerializedName("country")
    @Expose
    var country: String = ""
    @SerializedName("timezone")
    @Expose
    var timezone: Int = 0
    @SerializedName("sunrise")
    @Expose
    var sunrise: Int = 0
    @SerializedName("sunset")
    @Expose
    var sunset: Int = 0

}
