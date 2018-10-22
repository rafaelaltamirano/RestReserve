package com.quandoo.androidtask

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.quandoo.androidtask.tables.TablesActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class AcceptanceTest {

//    private lateinit var mCustomersPresenter: CustomersContract.Presenter
//    private val mFakeCustomers = createListOfFakeCustomers()

    @Rule
    @JvmField
    var mActivityTestRule: ActivityTestRule<TablesActivity> =
            ActivityTestRule(TablesActivity::class.java, true,
                    false)

    @Before
    fun setup() {

        //TODO : Mock data

        //launch activity using empty intent (no arguments needed for now ...)
        mActivityTestRule.launchActivity(Intent())
    }

    @After
    fun tearDown() {
    }


    /**
     * Make sure all initial UI elements are placed on the screen , and visible
     * to the user.
     */
    @Test
    fun allUiElementsAreDisplayed_Test() {
        // Check all views are displayed
        onView(withText("Tables")).check(matches(isDisplayed()))
//        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }

}