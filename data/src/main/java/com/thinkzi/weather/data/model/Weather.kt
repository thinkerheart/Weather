package com.thinkzi.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Weather {

    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("main")
    @Expose
    var main: String = ""
    @SerializedName("description")
    @Expose
    var description: String = ""
    @SerializedName("icon")
    @Expose
    var icon: String = ""

    init {
        this.id = 0
        this.main = ""
        this.description = ""
        this.icon = ""
    }

}
