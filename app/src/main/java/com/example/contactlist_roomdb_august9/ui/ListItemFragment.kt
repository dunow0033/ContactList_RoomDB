package com.example.contactlist_roomdb_august9.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.contactlist_roomdb_august9.databinding.ListItemTodoBinding

class ListItemFragment : Fragment() {
    private var _binding: ListItemTodoBinding? = null
    private val binding: LitItemTodoBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListItemTodoBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            deleteTodo.setOnClickListener{
                Log.d("TAG", "clicked!!")
                viewModel.deleteTodo(Todo(todoTask = todo))
            }
        }
    }
}