package com.quandoo.androidtask

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import com.example.domain.model.Customer
import com.example.domain.model.Reservation
import com.example.domain.model.Table
import com.example.domain.use_case.DeleteReservation
import com.example.domain.use_case.GetCustomers
import com.example.domain.use_case.GetReservations
import com.example.domain.use_case.GetTables
import com.example.domain.use_case.LoadReservations
import com.quandoo.androidtask.repositoryImp.FakeCustomersRepositoryImp
import com.quandoo.androidtask.repositoryImp.FakeReservationsRepositoryImp
import com.quandoo.androidtask.repositoryImp.FakeTablesRepositoryImp
import com.quandoo.androidtask.ui.theme.QuandooChallengeTheme
import com.quandoo.presentation.tables.TablesScreen
import com.quandoo.presentation.tables.TablesViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class OpenAppInOfflineModeInCacheModeTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var tablesViewModel: TablesViewModel
    private lateinit var tablesRepositoryFake: FakeTablesRepositoryImp
    private lateinit var reservationRepositoryFake: FakeReservationsRepositoryImp
    private lateinit var customerRepositoryFake: FakeCustomersRepositoryImp

    @Before
    fun setUp() {
        hiltRule.inject()

        // Mock Repositories
        tablesRepositoryFake = FakeTablesRepositoryImp()
        reservationRepositoryFake = FakeReservationsRepositoryImp()
        customerRepositoryFake = FakeCustomersRepositoryImp()

        // Initialize ViewModel with fake repositories
        tablesViewModel = TablesViewModel(
            GetTables(tablesRepositoryFake),
            GetReservations(reservationRepositoryFake),
            GetCustomers(customerRepositoryFake),
            DeleteReservation(reservationRepositoryFake),
            LoadReservations(reservationRepositoryFake),
            mockk(relaxed = true) // Mock Preferences
        )

        // Set up fake data
        tablesRepositoryFake.tables = listOf(
            Table(shape = "Square", id = 1),
            Table(shape = "Circle", id = 2),
            Table(shape = "Rectangle", id = 3)
        )
        reservationRepositoryFake.reservations = listOf(
            Reservation(userId = 1, tableId = 1, id = 101),
            Reservation(userId = 2, tableId = 2, id = 102),
            Reservation(userId = 3, tableId = 3, id = 103)
        )
        customerRepositoryFake.customers = listOf(
            Customer(id = 1, firstName = "John", lastName = "Doe", imageUrl = "https://example.com/johndoe.jpg"),
            Customer(id = 2, firstName = "Jane", lastName = "Smith", imageUrl = "https://example.com/janesmith.jpg"),
            Customer(id = 3, firstName = "Alice", lastName = "Johnson", imageUrl = "https://example.com/alicejohnson.jpg")
        )

        composeTestRule.activity.setContent {
            QuandooChallengeTheme {
                TablesScreen(
                    onNextClick = {},
                    tablesViewModel = tablesViewModel
                )
            }
        }
    }

    @Test
    fun openAppInOfflineModeInCacheModeTest() {
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("LazyColumnTables").assertExists()
        composeTestRule.onAllNodesWithTag("TableItems").assertCountEquals(3)

    }
}