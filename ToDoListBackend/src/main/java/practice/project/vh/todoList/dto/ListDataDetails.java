package practice.project.vh.todoList.dto;

import practice.project.vh.todoList.classes.ToDoList;
import practice.project.vh.todoList.classes.TodolistType;

public record ListDataDetails(Long id, String description, TodolistType todolistType) {

    public ListDataDetails(ToDoList toDoList) {
        this(toDoList.getId(), toDoList.getDescription(), toDoList.getTodolistType());
    }
}
