package com.macit.todoapp.service;

import com.macit.todoapp.model.Task;
import com.macit.todoapp.model.TodoList;
import com.macit.todoapp.model.TodoLists;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;

@Service
public class TodoListService {

    TodoLists todoLists = new TodoLists();


    public Set<TodoList> getTodoLists() {
        return todoLists.getTodoLists();
    }

    public void addTodoList(TodoList todoList) {
        todoLists.addTodoList(todoList);
    }

    public void removeTodoList(String todoListId) {
        todoLists.removeTodoList(todoListId);
    }

    public Set<Task> getAllTasksFromTodoList(String todoListId) {
        return todoLists.getAllTasksFromTodoList(todoListId);
    }

    public void addTaskToTodoList(String todoListId, Task task) {
        long taskId = LocalDateTime.now().atZone(ZoneId.of("UTC")).toInstant().toEpochMilli();
        task.setId(taskId);
        todoLists.addTaskToTodoList(todoListId, task);
    }

    public void removeTaskFromTodoList(String todoListId, String taskId) {
        todoLists.removeTaskFromTodoList(todoListId, taskId);
    }
}
