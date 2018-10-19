package com.quandoo.androidtask.api;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public class Table implements Serializable {

    @SerializedName("shape")
    String shape;

    @SerializedName("id")
    long id;

    public @Nullable String reservedBy;

    @Override
    public String toString() {
        return "Table{" +
                "shape='" + shape + '\'' +
                ", id=" + id +
                '}';
    }

    public String getShape() {
        return shape;
    }

    public long getId() {
        return id;
    }
}
