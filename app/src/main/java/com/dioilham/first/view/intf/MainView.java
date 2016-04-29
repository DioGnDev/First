package com.dioilham.first.view.intf;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by dioilham on 4/29/16.
 */
public interface MainView extends MvpView{

    void diplayHello(String message);
    void showError(String errorMessage);

}

