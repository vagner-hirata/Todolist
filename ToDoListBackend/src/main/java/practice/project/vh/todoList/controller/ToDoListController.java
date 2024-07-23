package practice.project.vh.todoList.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import practice.project.vh.todoList.classes.TodolistType;
import practice.project.vh.todoList.dto.RegisterListData;
import practice.project.vh.todoList.dto.ToDoDataList;
import practice.project.vh.todoList.dto.UpdateListData;
import practice.project.vh.todoList.exceptions.ListNotFoundException;
import practice.project.vh.todoList.services.ToDoListService;

import java.util.List;

@RestController
@RequestMapping("todolist")
public class ToDoListController {
        @Autowired
        ToDoListService toDoListService;

        @PostMapping("/add")
        @Transactional
        public ResponseEntity createList(@RequestBody @Valid RegisterListData data, UriComponentsBuilder uriBuilder) {
            return toDoListService.createList(data, uriBuilder);
        }

        @GetMapping("/all")
        public ResponseEntity<List<ToDoDataList>> showList() {
            return toDoListService.showList();

        }
        @PutMapping("/update")
        @Transactional
        public ResponseEntity updateList(@RequestBody @Valid UpdateListData data) {
            return toDoListService.updateList(data);
        }
        @DeleteMapping("/delete/{id}")
        @Transactional
        public ResponseEntity deleteList(@PathVariable Long id) {
                return toDoListService.deleteList(id);
        }

        @GetMapping("/all/{todolistType}")
        public ResponseEntity<List<ToDoDataList>> showAllByType(@PathVariable String todolistType) {
                if(toDoListService.isValidTodolistType(todolistType)) {
                        List<ToDoDataList> getTodolistType = toDoListService.showAllByType(TodolistType.valueOf(todolistType));
                        return ResponseEntity.status(HttpStatus.OK).body(getTodolistType);
                }
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

}
