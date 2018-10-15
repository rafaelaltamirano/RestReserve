package com.quandoo.androidtask.customers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.quandoo.androidtask.utils.Logger
import com.quandoo.androidtask.R
import com.quandoo.androidtask.api.Customer
import com.quandoo.androidtask.api.RestaurantService
import com.quandoo.androidtask.api.Table
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_customers.*
import java.lang.RuntimeException

class CustomersActivity : AppCompatActivity(), Logger {

    private var selectedTableId: Long = NON_EXISTING_TABLE_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customers)
        recycler_view.layoutManager = LinearLayoutManager(this)

        selectedTableId = intent.getLongExtra(EXTRA_TABLE_ID, -1)

        if (this.selectedTableId == NON_EXISTING_TABLE_ID) {
            throw RuntimeException("Selected table ID cannot be found !")
        }


        RestaurantService.Creator().create().getCustomers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Customer>>() {
                    override fun onError(e: Throwable) {
                        log(e.localizedMessage)
                    }

                    override fun onSuccess(value: List<Customer>) {
                        recycler_view.adapter = CustomersRvAdapter(value, object : CustomersRvAdapter.CustomerClickListener {
                            override fun onCustomerClick(customer: Customer) {
                                log("customer clicked $customer")

                                //TODO : Reserve table
                            }
                        })
                    }
                })
    }

    companion object {

        const val EXTRA_TABLE_ID = "SELECTED_TABLE_ID"
        const val NON_EXISTING_TABLE_ID = -1L

        @JvmStatic
        fun createStartingIntent(clickedTable: Table, context: Context): Intent {
            val intent = Intent(context, CustomersActivity::class.java)
            intent.putExtra(EXTRA_TABLE_ID, clickedTable.id)
            return intent
        }
    }
}