package com.quandoo.androidtask.tables;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.quandoo.androidtask.customers.CustomersActivity;
import com.quandoo.androidtask.utils.Logger;
import com.quandoo.androidtask.R;
import com.quandoo.androidtask.api.Reservation;
import com.quandoo.androidtask.api.RestaurantService;
import com.quandoo.androidtask.api.Table;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TablesActivity extends AppCompatActivity implements Logger {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));


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
                        rv.setAdapter(new TablesRvAdapter(value,
                                clickedTable ->
                                        startActivity(CustomersActivity
                                                .createStartingIntent(clickedTable, TablesActivity.this))));
                    }

                    @Override
                    public void onError(Throwable e) {
                        error(e.getLocalizedMessage());
                    }
                });
    }

    private void apiTests() {


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
