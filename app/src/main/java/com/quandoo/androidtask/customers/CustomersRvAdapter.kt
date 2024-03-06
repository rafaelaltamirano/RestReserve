package com.quandoo.androidtask.customers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.quandoo.androidtask.R
import com.quandoo.androidtask.api.Customer
import com.quandoo.androidtask.databinding.CustomerCellBinding
import com.quandoo.androidtask.utils.Logger
import com.squareup.picasso.Picasso

internal class CustomersRvAdapter(private val tables: List<Customer>,
                                  private val customerClickLstnr: CustomerClickListener) :
        RecyclerView.Adapter<CustomersRvAdapter.CustomerViewHolder>(), Logger {

    interface CustomerClickListener {
        fun onCustomerClick(customer: Customer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CustomerCellBinding.inflate(inflater, parent, false)
        return CustomerViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: CustomerViewHolder, position: Int) {
        val customer = tables[position]
        viewHolder.bind(customer)
    }

    override fun getItemCount(): Int {
        return tables.size
    }

    inner class CustomerViewHolder(private val binding: CustomerCellBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(customer: Customer) {
            binding.apply {
                customerNameTextView.text = "${customer.firstName} ${customer.lastName}"
                // Set customerAvatarImageView using Picasso or other image loading library
                root.setOnClickListener { customerClickLstnr.onCustomerClick(customer) }
            }
        }
    }
}