package com.thinkzi.weather.domain.entity;

public class Wind {

    private double _speed;
    private double _direction;

    public Wind() {
        this._speed = 0.0;
        this._direction = 0.0;
    }

    public double getSpeed() {
        return _speed;
    }

    public void setSpeed(double _speed) {
        this._speed = _speed;
    }

    public double getDirection() {
        return _direction;
    }

    public void setDirection(double _direction) {
        this._direction = _direction;
    }
}
