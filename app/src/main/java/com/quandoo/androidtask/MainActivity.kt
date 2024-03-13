package com.quandoo.androidtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.domain.preferences.Preferences
import com.quandoo.androidtask.navigation.navigate
import com.quandoo.androidtask.ui.theme.QuandooChallengeTheme
import com.quandoo.androidtask.utils.checkInternetConnection
import com.quandoo.presentation.components.AlertDialog
import com.quandoo.presentation.navigation.Route
import com.quandoo.presentation.tables.TablesScreen
import com.quandoo.presentation.users.CustomersScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var preferences: Preferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuandooChallengeTheme {
                val showDialog = remember { mutableStateOf(false) }
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()


                LaunchedEffect(Unit) {
                    if (!preferences.loadFirstRun()) {
                        val hasConnection = this@MainActivity.checkInternetConnection()
                        if (hasConnection) {
                            preferences.saveFirstRun(true)
                            return@LaunchedEffect
                        }
                        else showDialog.value = true
                        return@LaunchedEffect
                    }
                    showDialog.value = false
                }

                if (showDialog.value) {
                    AlertDialog(title = "Not internet connection",
                        message = "Please, connect your device to the internet to continue.",
                        onPressButton = {
                            val hasConnection = this@MainActivity.checkInternetConnection()
                            if (hasConnection) {
                                showDialog.value = false
                                preferences.saveFirstRun(true)
                            }
                        })
                } else {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState
                    ) {
                        val padding = it
                        NavHost(
                            navController = navController, startDestination = Route.TABLES

                        ) {
                            composable(Route.TABLES) {
                                TablesScreen(
                                    onNavigate = navController::navigate,
                                )
                            }
                            composable(Route.CUSTOMERS) {
                                CustomersScreen(
                                    onNavigate = navController::navigate,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}