package com.thinkzi.weather.ui.model;

public class CityUIModel {

    private int _id;
    private String _name;
    private CoordinateUIModel _coordinateUIModel;
    private String _country;

    public CityUIModel() {
        this._id = 0;
        this._name = "";
        this._country = "";
        this._coordinateUIModel = new CoordinateUIModel();
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

    public CoordinateUIModel getCoordinate() {
        return _coordinateUIModel;
    }

    public void setCoordinate(CoordinateUIModel _coordinateUIModel) {
        this._coordinateUIModel = _coordinateUIModel;
    }

    public String getCountry() {
        return _country;
    }

    public void setCountry(String _country) {
        this._country = _country;
    }
}
