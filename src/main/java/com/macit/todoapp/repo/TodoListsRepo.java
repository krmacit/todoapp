package com.macit.todoapp.repo;

import com.macit.todoapp.model.TodoList;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListsRepo extends CouchbaseRepository<TodoList, String> {
}
