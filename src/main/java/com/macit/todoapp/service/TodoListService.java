package com.macit.todoapp.service;

import com.macit.todoapp.model.Task;
import com.macit.todoapp.model.TodoList;
import com.macit.todoapp.repo.TodoListsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TodoListService {

    @Autowired
    TodoListsRepo todoListsRepo;

    public List<TodoList> getTodoLists() {
        return todoListsRepo.findAll();
    }

    public TodoList getTodoList(String todoListId) {
        Optional<TodoList> todoList = todoListsRepo.findById(todoListId);
        return todoList.orElseGet(() -> new TodoList(todoListId));
    }

    public void saveTodoList(TodoList todoList) {
        todoListsRepo.save(todoList);
    }

    public void removeTodoList(String todoListId) {
        todoListsRepo.deleteById(todoListId);
    }

    public Set<Task> getAllTasksFromTodoList(String todoListId) {
        return getTodoList(todoListId).getAllTasks();
    }

    public void addTaskToTodoList(String todoListId, Task task) {
        long taskId = LocalDateTime.now().atZone(ZoneId.of("UTC")).toInstant().toEpochMilli();
        task.setId(taskId);
        TodoList todoList = getTodoList(todoListId);
        todoList.addTask(task);
        todoListsRepo.save(todoList);
    }

    public void removeTaskFromTodoList(String todoListId, String taskId) {
        TodoList todoList = getTodoList(todoListId);
        todoList.removeTask(taskId);
        todoListsRepo.save(todoList);
    }
}
