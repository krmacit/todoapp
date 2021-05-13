package com.macit.todoapp.controller;

import com.macit.todoapp.model.Task;
import com.macit.todoapp.model.TodoList;
import com.macit.todoapp.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public ResponseEntity<Set<TodoList>> getUsers() {
        return new ResponseEntity<>(todoListService.getTodoLists(), HttpStatus.OK);
    }

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public ResponseEntity<String> addUser(@RequestBody TodoList todoList) {
        todoListService.addTodoList(todoList);
        return new ResponseEntity<>("User " + todoList.getUserId() + " is added.", HttpStatus.OK);
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeUser(@PathVariable String id) {
        todoListService.removeTodoList(id);
        return new ResponseEntity<>("User " + id + " is removed.", HttpStatus.OK);
    }

    @RequestMapping(value = "/todo/{id}/task", method = RequestMethod.GET)
    public ResponseEntity<Set<Task>> getTasks(@PathVariable String id) {
        return new ResponseEntity<>(todoListService.getAllTasksFromTodoList(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/todo/{id}/task", method = RequestMethod.POST)
    public ResponseEntity<String> addTask(@PathVariable String id, @RequestBody Task task) {
        todoListService.addTaskToTodoList(id, task);
        return new ResponseEntity<>("Task " + task.getName() + " is added.", HttpStatus.OK);
    }

    @RequestMapping(value = "/todo/{id}/task/{taskId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeTask(@PathVariable String id, @PathVariable String taskId) {
        todoListService.removeTaskFromTodoList(id, taskId);
        return new ResponseEntity<>("Task " + taskId + " is removed.", HttpStatus.OK);
    }

}
