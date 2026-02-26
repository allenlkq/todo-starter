package com.example.todo.service;

import com.example.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoService {

    // In-memory store: id -> Todo
    private final Map<Long, Todo> store = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Todo> findAll() {
        // TODO: return all todos from the store
        return null;
    }

    public Optional<Todo> findById(Long id) {
        // TODO: look up the todo by id in the store
        return Optional.empty();
    }

    public Todo create(Todo todo) {
        // TODO: assign a new id, put it in the store, and return it
        // Hint: use idCounter.getAndIncrement() to generate a unique id
        return null;
    }

    public boolean delete(Long id) {
        // TODO: remove from store, return true if it existed, false if not
        return false;
    }
}
