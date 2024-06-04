package practice.project.vh.todoList.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;


public record RegisterListData(
        @NotBlank
        String description
//        LocalDateTime dateCreated
) {
}
