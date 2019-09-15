package com.thinkzi.weather.data.net

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * provide a Retrofit instance to get data via webservice
 */
object APIConnection {

    @Volatile
    private var _retrofit: Retrofit? = null
    private val API_BASE_URL = "http://api.openweathermap.org"

    val instance: IRestAPI
        get() {

            if (_retrofit == null) {

                synchronized(APIConnection::class.java) {

                    _retrofit = Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                }

            }

            return _retrofit!!.create(IRestAPI::class.java)

        }

}
