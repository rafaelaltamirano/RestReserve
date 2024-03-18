package com.quandoo.androidtask

import android.content.Context
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.testing.TestNavHostController
import com.example.domain.model.Customer
import com.example.domain.model.Reservation
import com.example.domain.model.SelectedReservation
import com.example.domain.model.Table
import com.example.domain.preferences.Preferences
import com.example.domain.use_case.DeleteReservation
import com.example.domain.use_case.GetCustomers
import com.example.domain.use_case.GetReservations
import com.example.domain.use_case.GetTables
import com.example.domain.use_case.InsertReservation
import com.example.domain.use_case.LoadReservations
import com.example.domain.util.UiEvent
import com.quandoo.androidtask.repositoryImp.FakeCustomersRepositoryImp
import com.quandoo.androidtask.repositoryImp.FakeReservationsRepositoryImp
import com.quandoo.androidtask.repositoryImp.FakeTablesRepositoryImp
import com.quandoo.androidtask.ui.theme.QuandooChallengeTheme
import com.quandoo.androidtask.utils.InternetConnectionUtils
import com.quandoo.androidtask.utils.assertBackgroundColor
import com.quandoo.androidtask.utils.assertCurrentRouteName
import com.quandoo.presentation.components.BackPressHandler
import com.quandoo.presentation.components.CustomerItem
import com.quandoo.presentation.components.ReserveDialog
import com.quandoo.presentation.components.TableItem
import com.quandoo.presentation.navigation.Route
import com.quandoo.presentation.tables.TablesViewModel
import com.quandoo.presentation.users.CustomersViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainActivityTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var tablesViewModel: TablesViewModel
    private lateinit var customersViewModel: CustomersViewModel
    private lateinit var tablesRepositoryFake: FakeTablesRepositoryImp
    private lateinit var reservationRepositoryFake: FakeReservationsRepositoryImp
    private lateinit var customerRepositoryFake: FakeCustomersRepositoryImp
    private lateinit var mContextMock: Context
    private lateinit var preferences: Preferences
    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        hiltRule.inject()

        // Mock Repositories
        tablesRepositoryFake = FakeTablesRepositoryImp()
        reservationRepositoryFake = FakeReservationsRepositoryImp()
        customerRepositoryFake = FakeCustomersRepositoryImp()
        preferences = mockk(relaxed = true)
        mContextMock = mockk<Context>(relaxed = true)
        mockkObject(InternetConnectionUtils)
        every { InternetConnectionUtils.checkInternetConnection(any()) } returns false
        every { preferences.loadFirstRun() } returns true
        // Initialize ViewModel with fake repositories
        tablesRepositoryFake.tables = listOf(
            Table(shape = "Square", id = 1),
            Table(shape = "Circle", id = 2),
            Table(shape = "Rectangle", id = 3)
        )
        reservationRepositoryFake.reservations = listOf(
            Reservation(userId = 2, tableId = 2, id = 102),
            Reservation(userId = 3, tableId = 3, id = 103)
        )
        customerRepositoryFake.customers = listOf(
            Customer(
                id = 1,
                firstName = "John",
                lastName = "Doe",
                imageUrl = "https://example.com/johndoe.jpg"
            ), Customer(
                id = 2,
                firstName = "Jane",
                lastName = "Smith",
                imageUrl = "https://example.com/janesmith.jpg"
            ), Customer(
                id = 3,
                firstName = "Alice",
                lastName = "Johnson",
                imageUrl = "https://example.com/alicejohnson.jpg"
            )
        )

        tablesViewModel = TablesViewModel(
            GetTables(tablesRepositoryFake),
            GetReservations(reservationRepositoryFake),
            GetCustomers(customerRepositoryFake),
            DeleteReservation(reservationRepositoryFake),
            LoadReservations(reservationRepositoryFake),
            preferences // Mock Preferences
        )

        customersViewModel = CustomersViewModel(
            GetCustomers(customerRepositoryFake),
            InsertReservation(reservationRepositoryFake),
            preferences
        )


        composeTestRule.activity.setContent {
            QuandooChallengeTheme {
                val showDialog = remember { mutableStateOf(false) }
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())

                LaunchedEffect(Unit) {
                    if (!preferences.loadFirstRun()) {
                        val hasConnection =
                            InternetConnectionUtils.checkInternetConnection(mContextMock)
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
                    val scaffoldState = rememberScaffoldState()
                    Scaffold(
                        modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState
                    ) {
                        val padding = it
                        NavHost(
                            navController = navController, startDestination = Route.TABLES
                        ) {
                            composable(Route.TABLES) {

                                val state = tablesViewModel.state
                                BackPressHandler()


                                LaunchedEffect(key1 = true) {
                                    tablesViewModel.uiEvent.collect { event ->
                                        when (event) {
                                            is UiEvent.Navigate -> {
                                                navController.navigate(Route.CUSTOMERS)
                                            }

                                            is UiEvent.ShowCustomDialog -> {
                                                tablesViewModel.setShowDialog(true)
                                            }

                                            else -> Unit
                                        }
                                    }
                                }

                                ReserveDialog(show = state.showDialog,
                                    reserveNumber = state.selectedReservation?.reservationId.toString(),
                                    reservedBy = state.selectedReservation?.customerName,
                                    tableNumber = state.selectedReservation?.tableId.toString(),
                                    image = state.selectedReservation?.customerImage,
                                    onDismiss = { tablesViewModel.setShowDialog(false) },
                                    onDelete = {
                                        tablesViewModel.deleteReserve(
                                            state.selectedReservation?.reservationId ?: 0
                                        )
                                        tablesViewModel.setShowDialog(false)
                                    })

                                Column(

                                ) {
                                    Card(
                                        modifier = Modifier.fillMaxWidth(), elevation = 8.dp
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .padding(
                                                    horizontal = 16.dp, vertical = 8.dp
                                                )
                                                .fillMaxWidth(),
                                            verticalAlignment = Alignment.CenterVertically,

                                            ) {

                                            Text(
                                                text = "Reserved tables",
                                                color = Color.DarkGray,
                                                style = MaterialTheme.typography.h1,
                                                maxLines = 1,
                                            )
                                        }
                                    }
                                    LazyColumn(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(horizontal = 16.dp)
                                            .testTag("LazyColumnTables"),

                                        ) {
                                        items(state.tables.size) {
                                            val customer = tablesViewModel.findReservationUserName(
                                                state.reservations,
                                                state.customers,
                                                state.tables[it].id
                                            )
                                            val reservation =
                                                tablesViewModel.getReservationIdIfTableReserved(
                                                    state.tables[it], state.reservations
                                                )
                                            val table = state.tables[it]
                                            val customerName =
                                                customer?.firstName + " " + customer?.lastName
                                            val selectedReservation = SelectedReservation(
                                                customerName,
                                                reservation?.id ?: 0,
                                                reservation?.tableId ?: 0,
                                                customer?.imageUrl ?: ""
                                            )

                                            TableItem(tableId = table.id,
                                                customer = customer,
                                                shape = table.shape,
                                                hasReserve = reservation != null,
                                                onItemClick = { tableId ->
                                                    if (reservation != null) {
                                                        tablesViewModel.showCustomDialog()
                                                        tablesViewModel.setSelectedReservation(
                                                            selectedReservation
                                                        )
                                                    } else {
                                                        tablesViewModel.onNextClick(tableId)
                                                    }
                                                })
                                        }
                                    }
                                }
                            }
                            composable(Route.CUSTOMERS) {
                                val state = customersViewModel.state

                                LaunchedEffect(key1 = true) {
                                    customersViewModel.uiEvent.collect { event ->
                                        when (event) {
                                            is UiEvent.Navigate -> {
                                                navController.navigate(Route.TABLES)
                                            }

                                            else -> Unit
                                        }
                                    }
                                }

                                Column(
                                ) {
                                    Card(
                                        modifier = Modifier.fillMaxWidth(), elevation = 8.dp
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .padding(
                                                    horizontal = 16.dp, vertical = 8.dp
                                                )
                                                .fillMaxWidth(),
                                            verticalAlignment = Alignment.CenterVertically,

                                            ) {

                                            Text(
                                                text = "Costumers List",
                                                color = Color.DarkGray,
                                                style = MaterialTheme.typography.h1,
                                                maxLines = 1,
                                            )
                                        }
                                    }
                                    LazyColumn(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(horizontal = 16.dp),
                                    ) {
                                        items(state.customers.size) {

                                            CustomerItem(customer = state.customers[it],
                                                onItemClick = { selectedCustomerId ->
                                                    customersViewModel.saveCustomerPreference(
                                                        selectedCustomerId
                                                    )
                                                    customersViewModel.insertReservation()
                                                    customersViewModel.onSelectedCustomer()
                                                })
                                        }
                                    }
                                }
                            }
                        }

                    }
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

    @Test
    fun openAppInOfflineModeInCacheModeTest() {
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("LazyColumnTables").assertExists()
        composeTestRule.onNodeWithTag("LazyColumnTables").onChildren().assertCountEquals(3)

    }

    @Test
    fun TableReservationScreenTest() {

        val firstTable = tablesViewModel.state.tables.first()
        val firstCustomer = tablesViewModel.state.customers.first()

        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("LazyColumnTables").assertExists()

        composeTestRule.onNodeWithTag("Box${firstTable.id}", useUnmergedTree = true)
            .assertBackgroundColor(Color.Green)

        composeTestRule.onNodeWithTag("Table${firstTable.id}", useUnmergedTree = true)
            .performClick()

        composeTestRule.waitForIdle()

        navController.assertCurrentRouteName(Route.CUSTOMERS)


        composeTestRule.onNodeWithTag("Customer${firstCustomer.id}").performClick()

        every { preferences.loadReserve() } returns Reservation(
            userId = firstCustomer.id, tableId = firstTable.id, id = 101
        )

        customersViewModel.insertReservation()

        tablesViewModel.requestReservation()

        composeTestRule.waitForIdle()

        navController.assertCurrentRouteName(Route.TABLES)

        tablesViewModel.requestTables()

        composeTestRule.onNodeWithTag("Box${firstTable.id}", useUnmergedTree = true)
            .assertBackgroundColor(Color.Red)

        composeTestRule.onNodeWithTag("ReserveBy${firstTable.id}", useUnmergedTree = true)
            .assertTextEquals("Reserved by ${firstCustomer.firstName} ${firstCustomer.lastName}")
    }

    @Test
    fun TableReservationCancellation() {

        val secondTable = tablesViewModel.state.tables[1]
        val firstReservation = tablesViewModel.state.reservations.first()


        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("LazyColumnTables").assertExists()

        composeTestRule.onNodeWithTag(
                "Box${secondTable.id}",
                useUnmergedTree = true
            ).assertBackgroundColor(Color.Red)

        composeTestRule.onNodeWithTag(
            "Table${secondTable.id}", useUnmergedTree = true
        ).performClick()


        tablesViewModel.setShowDialog(true)

        composeTestRule.onNodeWithTag(
            "DeleteReserveButton", useUnmergedTree = true
        ).performClick()


        tablesViewModel.deleteReserve(firstReservation.id)

        tablesViewModel.setShowDialog(false)

        composeTestRule.onNodeWithTag(
            "Box${secondTable.id}",
            useUnmergedTree = true
        ).assertBackgroundColor(Color.Green)

        composeTestRule.onNodeWithTag("ReserveBy${secondTable.id}", useUnmergedTree = true)
            .assertTextEquals("FREE")


    }

    @Test
     fun ReservedTableVisualFeedback() {

        val secondTable = tablesViewModel.state.tables[1]
        val secondCustomer = customerRepositoryFake.customers[1]

        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("LazyColumnTables").assertExists()


        composeTestRule.onNodeWithTag("ReserveBy${secondTable.id}", useUnmergedTree = true)
            .assertTextEquals("Reserved by ${secondCustomer.firstName} ${secondCustomer.lastName}")

        composeTestRule.onNodeWithTag(
            "Table${secondTable.id}", useUnmergedTree = true
        ).performClick()


        tablesViewModel.setShowDialog(true)

        composeTestRule.waitForIdle()


        composeTestRule.onNodeWithContentDescription("profileCustomerImage${secondCustomer.firstName + " " + secondCustomer.lastName}").assertIsDisplayed()


      composeTestRule.onNodeWithContentDescription("profileCustomerImage${secondCustomer.firstName + " " + secondCustomer.lastName}").captureToImage()
            .asAndroidBitmap()
            .also { bitmapImage ->
                assertTrue(bitmapImage.width > 0 && bitmapImage.height > 0)
            }
    }
}
