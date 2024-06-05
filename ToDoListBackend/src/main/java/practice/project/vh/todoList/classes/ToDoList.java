package practice.project.vh.todoList.classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


import practice.project.vh.todoList.dto.RegisterListData;
import practice.project.vh.todoList.dto.UpdateListData;


import java.time.LocalDateTime;


@Table(name = "ToDoLists")
@Entity(name="ToDoList")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    public ToDoList(RegisterListData data) {

        this.description = data.description();

    }

    public void updateData(UpdateListData data) {
        if(data.description() != null) {
            this.description = data.description();
        }
    }
}
