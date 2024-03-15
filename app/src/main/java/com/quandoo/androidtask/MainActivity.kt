package com.quandoo.androidtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.domain.preferences.Preferences
import com.quandoo.androidtask.ui.theme.QuandooChallengeTheme
import com.quandoo.androidtask.utils.InternetConnectionUtils
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

                LaunchedEffect(Unit) {
                    if (!preferences.loadFirstRun()) {
                        val hasConnection = InternetConnectionUtils.checkInternetConnection(this@MainActivity)
                        if (hasConnection) {
                            preferences.saveFirstRun(true)
                            return@LaunchedEffect
                        } else showDialog.value = true
                        return@LaunchedEffect
                    }
                    showDialog.value = false
                }

                if (showDialog.value) {
                    ShowNoInternetDialog {
                        if (InternetConnectionUtils.checkInternetConnection(this@MainActivity)) {
                            showDialog.value = false
                            preferences.saveFirstRun(true)
                        }
                    }
                } else {
                    MainContent(navController)
                }
            }
        }
    }
}