package com.quandoo.androidtask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.quandoo.androidtask.api.Customer;
import com.quandoo.androidtask.api.Reservation;
import com.quandoo.androidtask.api.RestaurantService;
import com.quandoo.androidtask.api.Table;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements Logger {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new RestaurantService.Creator().create().getCustomers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new SingleObserver<List<Customer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(List<Customer> value) {
                        log(value.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        error(e.getLocalizedMessage());
                    }
                });


        new RestaurantService.Creator().create().getTables()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new SingleObserver<List<Table>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Table> value) {
                        log(value.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        error(e.getLocalizedMessage());
                    }
                });


        new RestaurantService.Creator().create().getReservations()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new SingleObserver<List<Reservation>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Reservation> value) {
                        log(value.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        error(e.getLocalizedMessage());
                    }
                });
    }
}
