package com.macit.todoapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@Document
@Data
public class TodoList {

    @Id
    private String userId;

    private Map<Long, Task> tasks;

    public TodoList() {
    }

    public TodoList(String userId) {
        this.userId = userId;
        this.tasks = new HashMap<>();
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void removeTask(String taskId) {
        tasks.remove(taskId);
    }

    public Set<Task> getAllTasks() {
        return new HashSet<>(tasks.values());
    }
}
