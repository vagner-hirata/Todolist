package practice.project.vh.todoList.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateListData(
        @NotNull
        Long id,
        String description,
        boolean completed
) {
}
