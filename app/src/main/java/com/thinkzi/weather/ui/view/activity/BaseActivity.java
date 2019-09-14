package com.thinkzi.weather.ui.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.thinkzi.weather.ui.WeatherApplication;
import com.thinkzi.weather.ui.di.ApplicationComponent;
import com.thinkzi.weather.ui.navigation.Navigator;

import javax.inject.Inject;

/**
 * provide Base {@link AppCompatActivity} class for every Activity in this application.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    Navigator _navigator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        this.getApplicationComponent().inject(this);
    }

    /**
     * get the Main Application component for dependency injection.
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((WeatherApplication)getApplication()).getApplicationComponent();
    }


}
