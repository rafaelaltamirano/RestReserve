package com.quandoo.androidtask.tables;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.quandoo.androidtask.R;
import com.quandoo.androidtask.api.Customer;
import com.quandoo.androidtask.api.Reservation;
import com.quandoo.androidtask.api.RestaurantService;
import com.quandoo.androidtask.api.Table;
import com.quandoo.androidtask.customers.CustomersActivity;
import com.quandoo.androidtask.utils.AppStatus;
import com.quandoo.androidtask.utils.Logger;
import com.quandoo.androidtask.utils.PersistanceUtil;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TablesActivity extends AppCompatActivity implements Logger {

    public static final String TABLES_FILE_NAME = "tables.bak";
    public static final String RESERVATIONS_FILE_NAME = "reservations.bak";
    public static final String CUSTOMERS_FILE_NAME = "customers.bak";

    private RecyclerView rv;

    // FIXME : >:) Muhahahahaha
    public static List<Table> tables;
    public static List<Reservation> reservations;
    public static List<Customer> customers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Tables");

        rv = findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));


        if (tables != null) {
            rv.setAdapter(new TablesRvAdapter(tables,
                    this::tablesClickListener));
            return;
        }


        //close the app when no internet
        if(!AppStatus.getInstance(getApplicationContext()).isOnline()){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("No internet connection!")
                    .setCancelable(false)
                    .setPositiveButton("Close App", (dialog, id) -> {
                        finish();
                    });
            AlertDialog alert = builder.create();
            alert.show();
            return;
        }


        //try to read objects from file
        tables = PersistanceUtil.readSerializable(TABLES_FILE_NAME);
        reservations = PersistanceUtil.readSerializable(RESERVATIONS_FILE_NAME);
        customers = PersistanceUtil.readSerializable(CUSTOMERS_FILE_NAME);

        if (tables != null && reservations != null && customers != null) {
            //Data is loaded from local storage. We can work with that.
            rv.setAdapter(new TablesRvAdapter(tables,
                    this::tablesClickListener));
            return;
        }


        // FIXME : >:) Muhahahahaha
        RestaurantService restaurantService = new RestaurantService.Creator().create();
        Single.zip(restaurantService.getTables(), restaurantService.getCustomers(), (tables1, customers1) -> {
            tables = tables1;
            customers = customers1;
            writeCustomersToFile(customers1);
            return tables1;
        }).zipWith(restaurantService.getReservations(), (o, reservations1) -> reservations1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new SingleObserver<List<Reservation>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Reservation> value) {
                        reservations = value;

                        // FIXME : >:) Muhahahahaha
                        reservations.forEach(reservation -> {
                            tables.forEach(table -> {
                                //find table from reservation
                                if (table.getId() == reservation.getTableId()) {
                                    customers.forEach(customer -> {
                                        //find user from reservation
                                        if (customer.getId() == reservation.getUserId()) {
                                            //mark table as reserved
                                            table.reservedBy = customer.getFirstName() + " " + customer.getLastName();
                                        }
                                    });
                                }
                            });
                        });

                        rv.setAdapter(new TablesRvAdapter(tables,
                                TablesActivity.this::tablesClickListener));

                        syncTables();
                        syncReservations(reservations);
                    }

                    @Override
                    public void onError(Throwable e) {
                        log(e.getLocalizedMessage());
                    }
                });

    }

    @NotNull
    public static void syncReservations(@NotNull List<? extends Reservation> reservations) {
        PersistanceUtil.saveSerializable(new ArrayList<>(reservations), RESERVATIONS_FILE_NAME);
    }

    private void writeCustomersToFile(List<Customer> customers) {
        PersistanceUtil.saveSerializable(new ArrayList<>(customers), CUSTOMERS_FILE_NAME);
    }

    private void tablesClickListener(Table clickedTable) {
        //show dialog for reserved table
        if (clickedTable.reservedBy != null) {

            //show dialog that removes the reservation
            AlertDialog.Builder builder = new AlertDialog.Builder(TablesActivity.this);
            builder.setMessage("Do you want to free the table?").setPositiveButton("Yes", (dialog, which) -> {

                //Free table
                clickedTable.reservedBy = null;
                syncTables();

            }).setNegativeButton("No", null).show();
        } else {
            startActivity(CustomersActivity
                    .createStartingIntent(clickedTable, TablesActivity.this));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        syncTables();
    }

    private void syncTables() {
        // FIXME : >:) Muhahahahaha
        if (tables != null && rv.getAdapter() != null) {
            if ((rv.getAdapter() instanceof TablesRvAdapter)) {
                TablesRvAdapter adapter = (TablesRvAdapter) rv.getAdapter();
                adapter.notifyDataSetChanged();
            }

            // Save tables into file
            PersistanceUtil.saveSerializable(new ArrayList<>(tables), TABLES_FILE_NAME);
        }
    }

}