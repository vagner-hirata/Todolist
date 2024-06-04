package practice.project.vh.todoList.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

}
