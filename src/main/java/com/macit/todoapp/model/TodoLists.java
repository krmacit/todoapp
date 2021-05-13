package com.macit.todoapp.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TodoLists {

    Map<String, TodoList> todoLists = new HashMap<>();

    public TodoLists() {
    }

    public TodoLists(Map<String, TodoList> todoLists) {
        this.todoLists = todoLists;
    }

    public Set<TodoList> getTodoLists() {
        return new HashSet<>(todoLists.values());
    }

    public void addTodoList(TodoList todoList) {
        todoLists.put(todoList.getUserId(), todoList);
    }

    public TodoList removeTodoList(String todoListId) {
        return todoLists.remove(todoListId);
    }

    public Set<Task> getAllTasksFromTodoList(String todoListId) {
        return todoLists.get(todoListId).getAllTasks();
    }

    public void addTaskToTodoList(String todoListId, Task task) {
        todoLists.get(todoListId).addTask(task);
    }

    public void removeTaskFromTodoList(String todoListId, String taskId) {
        todoLists.get(todoListId).removeTask(taskId);
    }
}
