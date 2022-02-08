package com.example.mvvm_hilt.ui.todo_list

import androidx.lifecycle.ViewModel
import com.example.mvvm_hilt.data.TodoRepository
import com.example.mvvm_hilt.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject


@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {


    val todos = repository.getTodos()

    // Channel for one time events = Mutable and immutable
    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


}