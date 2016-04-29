package com.dioilham.first.network;

import com.dioilham.first.model.CurrentWeatherModel;
import com.dioilham.first.util.Constanta;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dioilham on 4/29/16.
 */
public interface ServiceApi {

    @GET(Constanta.CURRENT_WEATHER_URL)
    Call<CurrentWeatherModel> getCurrentWeatherData();

}
