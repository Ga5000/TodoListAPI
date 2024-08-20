package com.ga5000.todolist.controller;

import com.ga5000.todolist.dto.CreateTodoDTO;
import com.ga5000.todolist.dto.TodoDTO;
import com.ga5000.todolist.dto.UpdateTodoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoController {
    ResponseEntity<TodoDTO> createTodo(CreateTodoDTO createTodoDTO);
    ResponseEntity<List<TodoDTO>> getAllTodos();
    ResponseEntity<List<TodoDTO>> getPriorityTodos();
    ResponseEntity<TodoDTO> updateTodo(Long todoId, UpdateTodoDTO updateTodoDTO);
    ResponseEntity<Void> deleteTodo(Long todoId);
}
