package com.ga5000.todolist.service;

import com.ga5000.todolist.dto.CreateTodoDTO;
import com.ga5000.todolist.dto.TodoDTO;
import com.ga5000.todolist.dto.UpdateTodoDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoService {
    TodoDTO createTodo(CreateTodoDTO createTodoDTO);
    List<TodoDTO> getAllTodos();
    List<TodoDTO> getPriorityTodos();
    TodoDTO updateTodo(Long todoId, UpdateTodoDTO updateTodoDTO);
    void deleteTodo(Long todoId);
}
