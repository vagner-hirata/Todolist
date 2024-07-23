package practice.project.vh.todoList.dto;

import practice.project.vh.todoList.classes.ToDoList;
import practice.project.vh.todoList.classes.TodolistType;


public record ToDoDataList(Long id, String description, TodolistType todolistType) {
        public ToDoDataList(ToDoList list) {
            this(list.getId(), list.getDescription(), list.getTodolistType());

        }
}
