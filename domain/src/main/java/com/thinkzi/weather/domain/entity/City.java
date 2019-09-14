package com.thinkzi.weather.domain.entity;

public class City {

    private int _id;
    private String _name;
    private Coordinate _coordinate;
    private String _country;

    public City() {
        this._id = 0;
        this._name = "";
        this._country = "";
        this._coordinate = new Coordinate();
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public Coordinate getCoordinate() {
        return _coordinate;
    }

    public void setCoordinate(Coordinate _coordinate) {
        this._coordinate = _coordinate;
    }

    public String getCountry() {
        return _country;
    }

    public void setCountry(String _country) {
        this._country = _country;
    }
}
