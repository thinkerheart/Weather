package com.thinkzi.weather.domain.entity;

public class Rain {

    private double _rainVolume;

    public Rain() {
        this._rainVolume = 0.0;
    }

    public double getRainVolume() {
        return _rainVolume;
    }

    public void setRainVolume(double _rainVolume) {
        this._rainVolume = _rainVolume;
    }

}
