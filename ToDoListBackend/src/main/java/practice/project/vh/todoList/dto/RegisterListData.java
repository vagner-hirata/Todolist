package practice.project.vh.todoList.dto;

import jakarta.validation.constraints.NotBlank;



public record RegisterListData(
        @NotBlank
        String description

) {
}
