package com.dioilham.first.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.dioilham.first.R;
import com.dioilham.first.presenter.MainPresenter;
import com.dioilham.first.view.intf.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{

    @BindView(R.id.hello)
    TextView helloText;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter(this);

        presenter.getDataFromServer();

    }

    @Override
    public void diplayHello(String message) {
        helloText.setText(message);
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }
}
