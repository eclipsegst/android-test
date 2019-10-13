package com.zhaolongzhong.android_test.ui

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.zhaolongzhong.android_test.MainActivity
import com.zhaolongzhong.android_test.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 *  Created by Zhaolong Zhong on 10/13/2019.
 */

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var stringToBetyped: String

    // Reference: https://developer.android.com/training/testing/ui-testing/espresso-testing#kotlin
    // By using ActivityTestRule, the testing framework launches the activity under test before
    // each test method annotated with @Test and before any method annotated with @Before.
    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        // Specify a valid string.
        stringToBetyped = "Espresso"
    }

    @Test
    fun testTextMatching() {
        onView(withId(R.id.hello_world_text_view_id)).check(matches(withText("Hello World!")))
        onView(withId(R.id.hello_world_text_view_id)).check(matches(withSubstring("Hello")))
    }

    @Test
    fun changeText_mainActivity() {
        // Type text and then press the button.
        onView(withId(R.id.user_input_edit_text_id))
            .perform(typeText(stringToBetyped), closeSoftKeyboard())
        onView(withId(R.id.change_text_button_id)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.text_to_be_changed_text_view_id))
            .check(matches(withText(stringToBetyped)))
    }
}