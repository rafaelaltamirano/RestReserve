package com.quandoo.androidtask;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.quandoo.androidtask.api.Table;

import java.util.List;

class TablesRvAdapter extends RecyclerView.Adapter<TablesRvAdapter.TableViewHolder> implements Logger {


    interface TableClickListener {
        void onTableItemClick(Table clickedTable);
    }

    private final List<Table> tables;
    private final TableClickListener clickLstnr;

    TablesRvAdapter(final List<Table> tables, final @NonNull TableClickListener clickLstnr) {
        this.tables = tables;
        this.clickLstnr = clickLstnr;
    }


    @NonNull
    @Override
    public TableViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.table_cell, viewGroup, false);
        return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableViewHolder viewHolder, int i) {
        Table table = this.tables.get(i);

        viewHolder.tableId.setText("" + table.getId());

        //TODO : Set name and color depending on reservation status
        viewHolder.reservingCustomerName.setText("Free");

        //TODO : set image depending on table shape
        viewHolder.itemView.setOnClickListener(v -> clickLstnr.onTableItemClick(table));
    }

    @Override
    public int getItemCount() {
        return tables.size();
    }

    static class TableViewHolder extends RecyclerView.ViewHolder {

        final TextView tableId;
        final TextView reservingCustomerName;
        final ImageView tableImage;

        TableViewHolder(View itemView) {
            super(itemView);

            tableId = itemView.findViewById(R.id.tableId);
            reservingCustomerName = itemView.findViewById(R.id.reservingCustomerName);
            tableImage = itemView.findViewById(R.id.tableImageView);
        }
    }
}