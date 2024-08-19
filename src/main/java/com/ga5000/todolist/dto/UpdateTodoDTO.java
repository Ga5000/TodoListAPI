package com.ga5000.todolist.dto;

import java.time.LocalDateTime;

public record UpdateTodoDTO(String title, String description, int priority,
                            LocalDateTime expireDate) {
}
