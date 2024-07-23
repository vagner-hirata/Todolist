package practice.project.vh.todoList.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

    List<ToDoList> findByTodolistType(TodolistType todolistType);

}
