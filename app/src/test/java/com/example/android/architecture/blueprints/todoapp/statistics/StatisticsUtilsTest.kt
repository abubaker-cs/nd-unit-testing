package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import junit.framework.Assert.assertEquals
import org.junit.Test


class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // 01 Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )

        // 02 Call our function
        val result = getActiveAndCompletedStats(tasks)

        // 03 Check the result
        assertEquals(0f, result.completedTasksPercent) // 0f = Active Task
        assertEquals(100f, result.activeTasksPercent) // 100f = Completed Task
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {

        // 01 Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = true),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false),
            Task("title", "desc", isCompleted = false)
        )

        // 02 Call our function
        val result = getActiveAndCompletedStats(tasks)

        // 03 Check the result
        assertEquals(40f, result.completedTasksPercent) // 0f = Active Task
        assertEquals(60f, result.activeTasksPercent) // 100f = Completed Task
    }

}
