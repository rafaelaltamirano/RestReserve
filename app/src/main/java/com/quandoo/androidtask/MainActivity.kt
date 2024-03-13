package com.quandoo.androidtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.quandoo.presentation.navigation.Route
import com.quandoo.androidtask.ui.theme.QuandooChallengeTheme
import com.quandoo.presentation.tables.TablesScreen
import dagger.hilt.android.AndroidEntryPoint
import com.quandoo.androidtask.navigation.navigate
import com.quandoo.presentation.users.CustomerState
import com.quandoo.presentation.users.CustomersScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuandooChallengeTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    val padding = it
                    NavHost(
                        navController = navController,
                        startDestination = Route.TABLES

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