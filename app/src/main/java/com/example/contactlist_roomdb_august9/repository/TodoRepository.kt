package com.example.contactlist_roomdb_august9.repository

import com.example.contactlist_roomdb_august9.db.TodoDatabase
import com.example.contactlist_roomdb_august9.model.Todo
import kotlinx.coroutines.flow.Flow

class TodoRepository(private val db: TodoDatabase) {

    suspend fun addTodo(todo: Todo) {
        db.getTodoDao().insertTodo(todo)
    }

    fun getTodos(): Flow<List<Todo>> {
        return db.getTodoDao().getTodos()
    }

    suspend fun deleteTodo(todo: Todo) {
        db.getTodoDao().deleteTodo(todo)
    }

    suspend fun updateTodo(todo: Todo) {
        db.getTodoDao().updateTodo(todo)
    }
}