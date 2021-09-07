package com.example.contactlist_roomdb_august9.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.contactlist_roomdb_august9.model.Todo
import com.example.contactlist_roomdb_august9.repository.TodoRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TodoViewModel(
    app: Application,
    private val repo: TodoRepository
) : AndroidViewModel(app) {

    private var _todos: MutableLiveData<List<Todo>> = MutableLiveData()
    val todos: LiveData<List<Todo>> = _todos

    init {
        getAllTodos()
    }

    private fun getAllTodos() {
        viewModelScope.launch {
            repo.getTodos().collect {
                _todos.postValue(it)
            }
        }
    }

    fun addTodo(todo: Todo) {
        viewModelScope.launch {
            repo.addTodo(todo)
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            repo.deleteTodo(todo)
        }
    }

    fun update(todo: Todo) {
        viewModelScope.launch {
            repo.updateTodo(todo)
        }
    }

}
