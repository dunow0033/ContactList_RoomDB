package com.example.contactlist_roomdb_august9.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.contactlist_roomdb_august9.repository.TodoRepository
import java.lang.IllegalArgumentException

class TodoViewModelFactory(
    private val app: Application,
    private val repo: TodoRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoViewModel::class.java)) {
            return TodoViewModel(app, repo) as T
        } else {
            throw IllegalArgumentException("instance of TodoViewModel cannot be created")
        }
    }

}