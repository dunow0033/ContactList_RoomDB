package com.example.contactlist_roomdb_august9.db

import androidx.room.*
import com.example.contactlist_roomdb_august9.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun addTodos(vararg todo : Array<Todo>)
//    suspend fun addTodos(todos : List<Todo>)

    @Query("SELECT * FROM todos")
    fun getTodos(): Flow<List<Todo>>

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Update
    suspend fun updateTodo(todo: Todo)
}