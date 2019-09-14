package com.thinkzi.weather.ui.model;

public class WeatherConditionUIModel {

    private int _id;
    private String _condition;
    private String _description;
    private String _icon;

    public WeatherConditionUIModel() {
        this._id = 0;
        this._condition = "";
        this._description = "";
        this._icon = "";
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getCondition() {
        return _condition;
    }

    public void setCondition(String _condition) {
        this._condition = _condition;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public String getIcon() {
        return _icon;
    }

    public void setIcon(String _icon) {
        this._icon = _icon;
    }
}
