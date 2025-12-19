package com.example.mindnest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


data class Task(
    val id: Long = System.currentTimeMillis(),
    val title: String,
    val description: String = ""
)

class TaskViewModel : ViewModel() {
    private val _tasks = MutableLiveData<MutableList<Task>>(mutableListOf())
    val tasks: LiveData<MutableList<Task>> = _tasks

    fun addTask(task: Task) {
        val updatedList = (_tasks.value ?: mutableListOf()).toMutableList()
        updatedList.add(task)
        _tasks.value = updatedList
    }

    fun removeTask(position: Int) {
        _tasks.value?.removeAt(position)
        _tasks.value = _tasks.value
    }
    fun updateTask(position: Int, newTitle: String) {
        val currentList = _tasks.value ?: return
        if (position in currentList.indices) {
            val oldTask = currentList[position]
            currentList[position] = oldTask.copy(title = newTitle)
            _tasks.value = currentList
        }
    }
}
