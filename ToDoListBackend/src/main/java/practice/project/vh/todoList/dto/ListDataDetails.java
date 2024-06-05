package practice.project.vh.todoList.dto;

import practice.project.vh.todoList.classes.ToDoList;

public record ListDataDetails(Long id, String description) {

    public ListDataDetails(ToDoList toDoList) {
        this(toDoList.getId(), toDoList.getDescription());
    }
}
