package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StatisticsUtilsTest {

    /**
     * Naming Convention:
     *
     * FORMAT:
     * subjectUnderTest_actionOrInput_resultState
     *
     * 1. subjectUnderTest = What we are testing
     * 2. actionOrInput = Action that occurs or the input state
     * 3. resultState = Result
     *
     * EXAMPLE:
     * getActiveAndCompletedStats_noCompleted_returnsHundredZero
     *
     */


    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // 01 GIVEN - Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )

        // 02 WHEN - Call our function
        val result = getActiveAndCompletedStats(tasks)

        // 03 THEN - Check the result
        assertThat(result.completedTasksPercent, `is`(0f)) // 0f = Active Task
        assertThat(result.activeTasksPercent, `is`(100f)) // 100f = Completed Task
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {

        // 01 GIVEN - Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false)
        )

        // 02 WHEN - Call our function
        val result = getActiveAndCompletedStats(tasks)

        // 03 THEN - Check the result
        assertEquals(40f, result.completedTasksPercent) // 0f = Active Task
        assertEquals(60f, result.activeTasksPercent) // 100f = Completed Task
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {

        // 01 GIVEN - Create an active tasks (the false makes this active)
        val tasks = emptyList<Task>()

        // 02 WHEN - Call our function
        val result = getActiveAndCompletedStats(tasks)

        // 03 THEN - Check the result
        assertEquals(0f, result.completedTasksPercent) // 0f = Active Task
        assertEquals(0f, result.activeTasksPercent) // 100f = Completed Task
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {

        // 01 GIVEN - Create an active tasks (the false makes this active)
        val tasks = null

        // 02 WHEN - Call our function
        val result = getActiveAndCompletedStats(tasks)

        // 03 THEN - Check the result
        assertEquals(0f, result.completedTasksPercent) // 0f = Active Task
        assertEquals(0f, result.activeTasksPercent) // 100f = Completed Task
    }

}
