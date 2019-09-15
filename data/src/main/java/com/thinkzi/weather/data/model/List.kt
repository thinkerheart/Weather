package com.thinkzi.weather.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class List {

    @SerializedName("dt")
    @Expose
    var dt: Int = 0
    @SerializedName("main")
    @Expose
    var main: Main = Main()
    @SerializedName("weather")
    @Expose
    var weather: ArrayList<Weather> = ArrayList()
    @SerializedName("clouds")
    @Expose
    var clouds: Clouds = Clouds()
    @SerializedName("wind")
    @Expose
    var wind: Wind = Wind()
    @SerializedName("sys")
    @Expose
    var sys: Sys = Sys()
    @SerializedName("dt_txt")
    @Expose
    var dtTxt: String = ""
    @SerializedName("rain")
    @Expose
    var rain: Rain = Rain()
    @SerializedName("snow")
    @Expose
    var snow: Snow = Snow()

    init {
        this.dt = 0
        this.main = Main()
        this.weather = ArrayList()
        this.clouds = Clouds()
        this.wind = Wind()
        this.sys = Sys()
        this.dtTxt = ""
        this.rain = Rain()
        this.snow = Snow()
    }
}
