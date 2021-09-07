package com.example.contactlist_roomdb_august9.db

import androidx.room.*
import com.example.contactlist_roomdb_august9.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

    @Query("SELECT * FROM todos")
    fun getTodos(): Flow<List<Todo>>

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Update
    suspend fun updateTodo(todo: Todo)
}