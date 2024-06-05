package practice.project.vh.todoList.dto;

import practice.project.vh.todoList.classes.ToDoList;



public record ToDoDataList(Long id, String description) {
        public ToDoDataList(ToDoList list) {
            this(list.getId(), list.getDescription());

        }
}
