package com.dioilham.first;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dioilham.first.model.CurrentWeatherModel;
import com.dioilham.first.network.ServiceApi;
import com.dioilham.first.network.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dioilham on 6/7/16.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDataFromServer();
    }

    public void getDataFromServer(){
        ServiceApi serviceApi = ServiceGenerator.createService(ServiceApi.class);
        retrofit2.Call<CurrentWeatherModel> call = serviceApi.getCurrentWeatherData();
        call.enqueue(new Callback<CurrentWeatherModel>() {
            @Override
            public void onResponse(Call<CurrentWeatherModel> call, Response<CurrentWeatherModel> response) {
                System.out.println(response.isSuccessful());

                CurrentWeatherModel model = response.body();
                List<CurrentWeatherModel.WeatherBean> weatherBeenList = model.getWeather();

                System.out.println(model.getId());
                System.out.println(model.getName());

                for (CurrentWeatherModel.WeatherBean w: weatherBeenList){
                    System.out.println(w.getDescription());
                }
            }

            @Override
            public void onFailure(Call<CurrentWeatherModel> call, Throwable t) {
            }
        });
    }
}


