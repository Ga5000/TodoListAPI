package com.ga5000.todolist.controller;

import com.ga5000.todolist.dto.CreateTodoDTO;
import com.ga5000.todolist.dto.TodoDTO;
import com.ga5000.todolist.dto.UpdateTodoDTO;
import com.ga5000.todolist.service.TodoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoControllerImpl implements TodoController{
    private final TodoServiceImpl todoService;

    public TodoControllerImpl(TodoServiceImpl todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    @Override
    public ResponseEntity<TodoDTO> createTodo(@RequestBody @Valid CreateTodoDTO createTodoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createTodo(createTodoDTO));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<TodoDTO>> getAllTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getAllTodos());
    }

    @GetMapping("/priority")
    @Override
    public ResponseEntity<List<TodoDTO>> getPriorityTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getPriorityTodos());
    }

    @PutMapping ("/{todoId}")
    @Override
    public ResponseEntity<TodoDTO> updateTodo(@PathVariable("todoId") Long todoId,
                                              @RequestBody @Valid UpdateTodoDTO updateTodoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.updateTodo(todoId,updateTodoDTO));
    }

    @DeleteMapping("/{todoId}")
    @Override
    public ResponseEntity<Void> deleteTodo(@PathVariable("todoId") Long todoId) {
        todoService.deleteTodo(todoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
