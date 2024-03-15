package com.quandoo.androidtask

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.quandoo.androidtask.navigation.navigate
import com.quandoo.presentation.navigation.Route
import com.quandoo.presentation.tables.TablesScreen
import com.quandoo.presentation.users.CustomersScreen


@Composable
 fun MainContent(navController: NavHostController) {
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
                    onNavigate = navController::navigate
                )
            }
        }
    }
}