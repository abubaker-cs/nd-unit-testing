package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class TasksViewModelTest {

    @Test
    fun addNewTask_setsNewTaskEvent() {

        // GIVEN - A Fresh TaskViewModel
        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        // WHEN - Adding a new task
        tasksViewModel.addNewTask()

        // THEN - The New Task Event is triggered

    }

}
