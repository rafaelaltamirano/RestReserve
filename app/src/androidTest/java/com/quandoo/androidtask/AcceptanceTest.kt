package com.quandoo.androidtask

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.quandoo.androidtask.EspressoCustomMarchers.Companion.first
import com.quandoo.androidtask.EspressoCustomMarchers.Companion.withHolderTablesView
import com.quandoo.androidtask.tables.TablesActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.os.AsyncTask
import android.support.test.espresso.action.ViewActions.click
import com.quandoo.androidtask.tables.TablesRvAdapter
import io.reactivex.schedulers.Schedulers
import io.reactivex.Scheduler
import io.reactivex.plugins.RxJavaPlugins
import org.hamcrest.CoreMatchers.allOf


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

        //make espresso wait for RXJava
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.from(AsyncTask.THREAD_POOL_EXECUTOR) }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.from(AsyncTask.THREAD_POOL_EXECUTOR) }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.from(AsyncTask.THREAD_POOL_EXECUTOR) }


        //launch activity using empty intent (no arguments needed for now ...)
        mActivityTestRule.launchActivity(Intent())
    }

    @After
    fun tearDown() {
    }


    @Test
    fun tableReservationTest() {

        //GIVEN :

        //App is open
        onView(withText("Tables")).check(matches(isDisplayed()))

        // List of tables visible
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))

        //There is at least one free table visible
        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.scrollToHolder(first(withHolderTablesView("Free"))))

        //WHEN :


        //FIXME : Clicks the wrong item !
        //User clicks on free table
        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions.scrollToHolder(first(withHolderTablesView("Free"))), click())


        //THEN :


        //Screen with customers appear
//        EspressoCustomMarchers.waitForView(R.id.recycler_view,2000)
//
//                When :
//
//        User clicks on a user
//
//        Then :
//
//        Screen with users tables appear
//        Previously selected table is marked as reserved by a user name

        // Check all views are displayed

//        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }

    fun wait(seconds: Int = 1) {
        Thread.sleep(seconds * 1000L)
    }

}