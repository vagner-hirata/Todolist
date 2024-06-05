package practice.project.vh.todoList.dto;

import practice.project.vh.todoList.classes.ToDoList;

import java.time.LocalDateTime;

public record ListDataDetails(Long id, String description,  boolean completed) {

    public ListDataDetails(ToDoList toDoList) {
        this(toDoList.getId(), toDoList.getDescription(), toDoList.isCompleted());
    }
}
