package com.example.contactlist_roomdb_august9.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.contactlist_roomdb_august9.adapters.TodoAdapter
import com.example.contactlist_roomdb_august9.databinding.FragmentTodoBinding
import com.example.contactlist_roomdb_august9.databinding.ListItemTodoBinding
import com.example.contactlist_roomdb_august9.db.TodoDatabase
import com.example.contactlist_roomdb_august9.model.Todo
import com.example.contactlist_roomdb_august9.repository.TodoRepository

class TodoFragment : Fragment() {

    private var _binding: FragmentTodoBinding? = null
    private val binding: FragmentTodoBinding get() = _binding!!

    private var _binding2: ListItemTodoBinding? = null
    private val binding2: ListItemTodoBinding get() = _binding2

    private val viewModel: TodoViewModel by viewModels {
        TodoViewModelFactory(
            requireActivity().application,
            TodoRepository(TodoDatabase(requireActivity()))
        )
    }
    private val todoAdapter: TodoAdapter by lazy {
        TodoAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnAddTodo.setOnClickListener {
                val todo = etTodo.editText?.text.toString()
                viewModel.addTodo(Todo(todoTask = todo))
                etTodo.editText?.setText("")
            }

            rvTodo.apply {
                adapter = todoAdapter
                rvTodo.layoutManager?.let {
                    addItemDecoration(DividerItemDecoration(requireContext(), it.layoutDirection))
                }
            }



            viewModel.todos.observe(viewLifecycleOwner) {
                todoAdapter.differ.submitList(it)
            }
        }

        with(binding2){
            deleteTodo.setOnClickListener{
                Log.d("TAG", "clicked!!")
                viewModel.deleteTodo(Todo(todoTask = todo))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}