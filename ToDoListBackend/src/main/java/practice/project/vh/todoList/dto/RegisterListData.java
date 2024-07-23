package practice.project.vh.todoList.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import practice.project.vh.todoList.classes.TodolistType;


public record RegisterListData(
        @NotBlank
        String description,
        @NotNull
        TodolistType todolistType

) {
}
