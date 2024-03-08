package com.quandoo.androidtask.customers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.quandoo.androidtask.api.Customer
import com.quandoo.androidtask.api.Reservation
import com.quandoo.androidtask.api.Table
import com.quandoo.androidtask.databinding.ActivityCustomersBinding
import com.quandoo.androidtask.tables.TablesActivity
import com.quandoo.androidtask.utils.Logger

class CustomersActivity : AppCompatActivity(), Logger {

    private var selectedTableId: Long = NON_EXISTING_TABLE_ID
    private lateinit var binding: ActivityCustomersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        selectedTableId = intent.getLongExtra(EXTRA_TABLE_ID, -1)

        if (this.selectedTableId == NON_EXISTING_TABLE_ID) {
            throw RuntimeException("Selected table ID cannot be found !")
        }

        binding.recyclerView.adapter = CustomersRvAdapter(TablesActivity.customers, object : CustomersRvAdapter.CustomerClickListener {
            override fun onCustomerClick(customer: Customer) {
                log("customer clicked $customer")

                //Reserve table
                TablesActivity.tables.find { table -> table.id == selectedTableId }?.let {
                    //create reservation
                    TablesActivity.reservations.add(
                        Reservation(
                            customer.id,
                            it.id,
                            customer.id + it.id
                        )
                    )
                    it.reservedBy = customer.firstName + " " + customer.lastName
                }

                TablesActivity.syncReservations(TablesActivity.reservations)

                finish()
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