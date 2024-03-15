package com.quandoo.androidtask

import android.content.Context
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import com.example.domain.preferences.Preferences
import com.quandoo.androidtask.ui.theme.QuandooChallengeTheme
import com.quandoo.androidtask.utils.InternetConnectionUtils
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainActivityTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var preferences: Preferences
    private lateinit var mContextMock: Context

    @Before
    fun setUp() {
        hiltRule.inject()
        preferences = mockk(relaxed = true)
        mContextMock = mockk<Context>(relaxed = true)
        mockkObject(InternetConnectionUtils)
        every { InternetConnectionUtils.checkInternetConnection(any()) } returns false

        composeTestRule.activity.setContent {
            QuandooChallengeTheme {
                val showDialog = remember { mutableStateOf(false) }
                val navController = rememberNavController()

                LaunchedEffect(Unit) {
                    if (!preferences.loadFirstRun()) {
                        val hasConnection = InternetConnectionUtils.checkInternetConnection(mContextMock)
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
                        if (InternetConnectionUtils.checkInternetConnection(mContextMock)) {
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

    @Test
    fun noInternetConnectionDialogNotVisibleOnFirstLaunchWithoutInternet() {
        every { preferences.loadFirstRun() } returns false
        composeTestRule.onNodeWithText("Not internet connection").assertExists()
        composeTestRule.onNodeWithText("Please, connect your device to the internet to continue.")
            .assertExists()
    }
}