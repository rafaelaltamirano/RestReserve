package com.quandoo.androidtask.utils

import android.content.Context
import android.net.ConnectivityManager

object InternetConnectionUtils {
    fun checkInternetConnection(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return capabilities != null
    }
}