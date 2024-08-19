package com.ga5000.todolist.dto;

import java.time.LocalDateTime;

public record TodoDTO(Long todoId, String title, String description, boolean finished, int priority,
                      LocalDateTime createdAt, LocalDateTime expireDate, boolean expired) {
}
