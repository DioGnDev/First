package com.dioilham.first.presenter;

import com.dioilham.first.model.CurrentWeatherModel;
import com.dioilham.first.network.ServiceApi;
import com.dioilham.first.network.ServiceGenerator;
import com.dioilham.first.view.intf.MainView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dioilham on 4/29/16.
 */
public class MainPresenter {

    MainView view;
    ServiceGenerator serviceGenerator;

    public MainPresenter(MainView view) {
        this.view = view;
        serviceGenerator = new ServiceGenerator();
    }

    public void hello(){
        if(view != null){
            view.diplayHello("hello");
        }
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
                if (view != null){
                    view.showError(t.getMessage());
                }
            }
        });
    }

}
