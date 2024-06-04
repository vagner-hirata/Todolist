package practice.project.vh.todoList.exceptions;

public class ListNotFoundException extends RuntimeException {
    public ListNotFoundException(String msg) {
        super(msg);
    }
}
