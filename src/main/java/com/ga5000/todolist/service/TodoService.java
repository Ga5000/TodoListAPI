package com.ga5000.todolist.service;

import com.ga5000.todolist.exception.TodoNotFoundException;
import com.ga5000.todolist.model.Todo;
import com.ga5000.todolist.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void saveTodo(Todo todo){
        todoRepository.save(todo);
    }

    public List<Todo> getAllTodos(){
        Sort sort = Sort.by("priority").descending().and(
                Sort.by("title").ascending());
        return todoRepository.findAll(sort);
    }

    public void delete(Long id){
        todoRepository.deleteById(id);
    }

    public Optional<Todo> findTodoById(Long id){
        return todoRepository.findById(id);

    }
}
