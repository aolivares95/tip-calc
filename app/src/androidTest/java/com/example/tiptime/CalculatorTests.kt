package com.example.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.core.StringContains.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTests {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_percent_tip(){
        /*
        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/cost_of_service_edit_text"
         */
        //onView is a view matcher that finds the view with the given id
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))
           // .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.calculate_button))
            .perform(click())
        //check assertion takes a viewAssertion. ViewAssertion...
        //is part of the espresso test suite and is used for UI components

        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$10.00"))))
    }
}