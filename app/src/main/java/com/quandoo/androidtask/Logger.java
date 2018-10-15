package com.quandoo.androidtask;

import android.util.Log;

public interface Logger {

    String LOG_TAG = "TestTask";

    default void log(String msg) {
        Log.d(LOG_TAG, msg);
    }

    default void error(String msg) {
        Log.e(LOG_TAG, msg);
    }

}
