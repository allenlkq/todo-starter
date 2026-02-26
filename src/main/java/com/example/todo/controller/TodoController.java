package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    // GET /todos — return all todos
    @GetMapping
    public List<Todo> getAll() {
        // TODO: call service and return the list
        return null;
    }

    // GET /todos/{id} — return one todo, or 404
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getById(@PathVariable Long id) {
        // TODO: return 200 with todo if found, 404 if not
        return ResponseEntity.notFound().build();
    }

    // POST /todos — create a new todo, return 201
    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        // TODO: create and return 201 Created
        // Hint: ResponseEntity.status(201).body(...)
        return ResponseEntity.ok(null);
    }

    // DELETE /todos/{id} — delete, return 204 or 404
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        // TODO: delete and return 204 if deleted, 404 if not found
        return ResponseEntity.noContent().build();
    }
}
