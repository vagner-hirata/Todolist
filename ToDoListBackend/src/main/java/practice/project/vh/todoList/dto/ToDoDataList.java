package practice.project.vh.todoList.dto;

import practice.project.vh.todoList.classes.ToDoList;

import java.time.LocalDateTime;

public record ToDoDataList(Long id,
                           String description,
//                           LocalDateTime dateCreated,
                           boolean completed) {
        public ToDoDataList(ToDoList list) {
            this(list.getId(),
            list.getDescription(),
//            list.getDateCreated(),
            list.isCompleted());

        }
}
