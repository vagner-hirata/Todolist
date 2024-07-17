package practice.project.vh.todoList.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import practice.project.vh.todoList.classes.ToDoList;
import practice.project.vh.todoList.classes.ToDoListRepository;
import practice.project.vh.todoList.dto.ToDoDataList;
import practice.project.vh.todoList.dto.ListDataDetails;
import practice.project.vh.todoList.dto.RegisterListData;
import practice.project.vh.todoList.dto.UpdateListData;
import practice.project.vh.todoList.exceptions.ListNotFoundException;

import java.net.URI;
import java.util.List;

@Service
public class ToDoListService {
    @Autowired
    private ToDoListRepository toDoListRepository;


    // Post Method for creating the list on the database
    public ResponseEntity createList(RegisterListData data, UriComponentsBuilder uriBuilder) {

        ToDoList toDoList = new ToDoList(data);
        toDoListRepository.save(toDoList);
        URI uri = uriBuilder.path("/todoList/{id}").buildAndExpand(toDoList.getId()).toUri();
        return ResponseEntity.created(uri).body(new ListDataDetails(toDoList));
    }
    // Get Method using list to show all
    public ResponseEntity<List<ToDoDataList>> showList() {
        List<ToDoDataList> list = toDoListRepository.findAll().stream().map(ToDoDataList::new).toList();
        return ResponseEntity.ok(list);
    }

    // put method, update the data in the database
    public ResponseEntity updateList(UpdateListData data) {
        isNotValidId(data.id());
        ToDoList list = toDoListRepository.getReferenceById(data.id());
        list.updateData(data);
        return ResponseEntity.ok(new ListDataDetails(list));
    }

    // delete method, delete or turn data invisible

    public ResponseEntity deleteList(Long id) {
        isNotValidId(id);
        toDoListRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    private void isNotValidId(Long id) {
        if(!toDoListRepository.existsById(id)) {
            throw new ListNotFoundException("List by id" + id + " was not found!");
        }
    }


}
