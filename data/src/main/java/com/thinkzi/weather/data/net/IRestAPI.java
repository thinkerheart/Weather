package com.thinkzi.weather.data.net;

import com.thinkzi.weather.data.model.Result;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * provide a interface to use Retrofit to get data via webservice
 * */
public interface IRestAPI {

    @GET("/data/2.5/forecast?")
    Single<Result> getWeatherForFiveDaysInACity(@Query("id") int _id, @Query("appid") String _appid);

}
