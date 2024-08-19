package com.ga5000.todolist.service;

import com.ga5000.todolist.dto.CreateTodoDTO;
import com.ga5000.todolist.dto.TodoDTO;
import com.ga5000.todolist.dto.UpdateTodoDTO;
import com.ga5000.todolist.exception.TodoExistsException;
import com.ga5000.todolist.exception.TodoNotFoundException;
import com.ga5000.todolist.model.Todo;
import com.ga5000.todolist.repository.TodoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoDTO createTodo(CreateTodoDTO createTodoDTO){
        Todo todo = todoRepository.findByTitle(createTodoDTO.title());
        if(todo != null){
            throw new TodoExistsException("This todo already exists");
        }
        Todo newTodo = new Todo();
        BeanUtils.copyProperties(createTodoDTO,newTodo);
        newTodo.setCreationDate(LocalDateTime.now());
        newTodo.setFinished(false);
        newTodo.setExpired(false);

        todoRepository.save(newTodo);

        return toTodoDTO(newTodo);

    }

    @Override
    public List<TodoDTO> getAllTodos(){
        return todoRepository.findAll()
                .stream().map(this::toTodoDTO).toList();
    }

    @Override
    public List<TodoDTO> getPriorityTodos(){
        return todoRepository.findAll()
                .stream().map(this::toTodoDTO)
                .filter(todo -> todo.priority() == 1).toList();
    }

    @Override
    public TodoDTO updateTodo(Long todoId, UpdateTodoDTO updateTodoDTO){
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found"));

        BeanUtils.copyProperties(updateTodoDTO,todo);
        todoRepository.save(todo);

            return toTodoDTO(todo);
    }

    @Override
    public void deleteTodo(Long todoId){
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found"));

        todoRepository.deleteById(todoId);
    }

    private TodoDTO toTodoDTO(Todo todo){
        return new TodoDTO(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.isFinished(),
                todo.getPriority(),
                todo.getCreationDate(),
                todo.getExpireDate(),
                todo.isExpired()
        );
    }


}
