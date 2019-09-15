package com.thinkzi.weather.domain.entity

class City {

    var id: Int = 0
    var name: String = ""
    var coordinate: Coordinate = Coordinate()
    var country: String = ""

    init {
        this.id = 0
        this.name = ""
        this.country = ""
        this.coordinate = Coordinate()
    }
}
