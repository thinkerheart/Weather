package com.thinkzi.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class Result {

    @SerializedName("cod")
    @Expose
    var cod: String = ""
    @SerializedName("message")
    @Expose
    var message: Double = 0.0
    @SerializedName("cnt")
    @Expose
    var cnt: Int = 0
    @SerializedName("list")
    @Expose
    var list: ArrayList<List> = ArrayList()
    @SerializedName("city")
    @Expose
    var city: City = City()

    init {
        this.cod = ""
        this.message = 0.0
        this.cnt = 0
        this.list = ArrayList()
        this.city = City()
    }

}
