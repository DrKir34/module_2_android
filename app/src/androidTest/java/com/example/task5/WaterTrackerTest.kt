package com.example.task5

import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithText
import junit.framework.TestCase.assertEquals

import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testAddWater() {
        composeTestRule.setContent {
            WaterTracker()
        }

        assertEquals(
            1,
            composeTestRule.onAllNodesWithText("0 мл")
                .fetchSemanticsNodes().size
        )

        assertEquals(
            1,
            composeTestRule.onAllNodesWithText("+250 мл")
                .fetchSemanticsNodes().size
        )

        composeTestRule.onNodeWithText("+250 мл")
            .performClick()

        assertEquals(
            1,
            composeTestRule.onAllNodesWithText("250 мл")
                .fetchSemanticsNodes().size
        )

        composeTestRule.onNodeWithText("+250 мл")
            .performClick()

        assertEquals(
            1,
            composeTestRule.onAllNodesWithText("500 мл")
                .fetchSemanticsNodes().size
        )
    }

    @Test
    fun testFinishDay() {
        composeTestRule.setContent {
            WaterTracker()
        }

        repeat(6) {
            composeTestRule.onNodeWithText("+250 мл")
                .performClick()
        }

        composeTestRule.onNodeWithText("Завершить день")
            .performClick()

        assertEquals(
            1,
            composeTestRule.onAllNodesWithText("0 мл")
                .fetchSemanticsNodes().size
        )

        assertEquals(
            1,
            composeTestRule.onAllNodesWithText(
                "Дней без обезвоживания: 1"
            ).fetchSemanticsNodes().size
        )
    }

    @Test
    fun testResetDayCount() {
        composeTestRule.setContent {
            WaterTracker()
        }

        repeat(6) {
            composeTestRule.onNodeWithText("+250 мл")
                .performClick()
        }

        composeTestRule.onNodeWithText("Завершить день")
            .performClick()

        assertEquals(
            1,
            composeTestRule.onAllNodesWithText(
                "Дней без обезвоживания: 1"
            ).fetchSemanticsNodes().size
        )

        repeat(4) {
            composeTestRule.onNodeWithText("+250 мл")
                .performClick()
        }

        composeTestRule.onNodeWithText("Завершить день")
            .performClick()

        assertEquals(
            1,
            composeTestRule.onAllNodesWithText(
                "Дней без обезвоживания: 0"
            ).fetchSemanticsNodes().size
        )
    }
}