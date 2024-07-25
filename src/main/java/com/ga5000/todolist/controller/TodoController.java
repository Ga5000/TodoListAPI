package com.ga5000.todolist.controller;

import com.ga5000.todolist.dto.TodoDTO;
import com.ga5000.todolist.exception.TodoNotFoundException;
import com.ga5000.todolist.model.Todo;
import com.ga5000.todolist.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Valid TodoDTO todoDTO){
        var todo = new Todo();
        BeanUtils.copyProperties(todoDTO,todo);
        todo.setCreationDate(LocalDateTime.now());

        todoService.saveTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Todo created successfully");
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getAllTodos());
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(Todo todo){
        todoService.saveTodo(todo);
        return ResponseEntity.status(HttpStatus.OK).body("Todo updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Optional<Todo> optionalTodo = todoService.findTodoById(id);
        if(optionalTodo.isEmpty()) throw new TodoNotFoundException("Todo not found");

        return ResponseEntity.status(HttpStatus.OK).body("Todo deleted successfully");
    }
}
