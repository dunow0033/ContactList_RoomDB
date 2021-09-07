package com.example.contactlist_roomdb_august9.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.contactlist_roomdb_august9.model.Todo

class TodoViewModel(app: Application) : AndroidViewModel(app) {

    private var _todos: MutableLiveData<List<Todo>> = MutableLiveData()
    val todos: LiveData<List<Todo>> = _todos

}
