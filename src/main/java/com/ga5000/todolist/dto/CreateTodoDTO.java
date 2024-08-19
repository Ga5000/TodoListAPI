package com.ga5000.todolist.dto;

import java.time.LocalDateTime;

public record CreateTodoDTO(String title, String description, boolean finished, int priority,
                            LocalDateTime expireDate) {
}
