package com.example.contactlist_roomdb_august9.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.contactlist_roomdb_august9.adapters.TodoAdapter
import com.example.contactlist_roomdb_august9.databinding.FragmentTodoBinding

class TodoFragment : Fragment() {

    private var _binding: FragmentTodoBinding? = null
    private val binding: FragmentTodoBinding get() = _binding!!

    private val viewModel: TodoViewModel by viewModels()
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}