package com.thinkzi.weather.ui.model

class CityUIModel {

    var id: Int = 0
    var name: String = ""
    var coordinate: CoordinateUIModel = CoordinateUIModel()
    var country: String = ""

    init {
        this.id = 0
        this.name = ""
        this.country = ""
        this.coordinate = CoordinateUIModel()
    }
}
