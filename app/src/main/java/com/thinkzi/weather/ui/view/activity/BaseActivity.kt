package com.thinkzi.weather.ui.view.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

import com.thinkzi.weather.ui.WeatherApplication
import com.thinkzi.weather.ui.di.ApplicationComponent
import com.thinkzi.weather.ui.navigation.Navigator

import javax.inject.Inject

/**
 * provide Base [AppCompatActivity] class for every Activity in this application.
 */
abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var _navigator: Navigator

    /**
     * get the Main Application component for dependency injection.
     */
    protected val applicationComponent: ApplicationComponent?
        get() = (application as WeatherApplication).applicationComponent

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        this.applicationComponent!!.inject(this)
    }


}
