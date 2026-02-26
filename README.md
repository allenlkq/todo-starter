# Todo API — Spring Boot Starter (In-Memory)

## Your Task (30 minutes)

Fill in the `// TODO` comments in `TodoService.java` and `TodoController.java`.
No database, no JPA — just a plain `HashMap` already set up for you.

---

## Project Structure

```
src/main/java/com/example/todo/
├── TodoApplication.java        ✅ Done
├── model/
│   └── Todo.java               ✅ Done — id, title, completed
├── service/
│   └── TodoService.java        ⬅️ TODO: implement 4 methods
└── controller/
    └── TodoController.java     ⬅️ TODO: implement 4 endpoints
```

---

## Steps

### 1. Implement `TodoService.java`

The `store` (a `HashMap<Long, Todo>`) and `idCounter` are already provided.

| Method | Hint |
|---|---|
| `findAll()` | `new ArrayList<>(store.values())` |
| `findById(id)` | `Optional.ofNullable(store.get(id))` |
| `create(todo)` | assign id via `idCounter.getAndIncrement()`, then `store.put(...)` |
| `delete(id)` | `store.remove(id)` returns null if missing |

### 2. Implement `TodoController.java`

| Method | Path | Expected Response |
|---|---|---|
| GET | `/todos` | 200 + list |
| GET | `/todos/{id}` | 200 or 404 |
| POST | `/todos` | 201 + created todo |
| DELETE | `/todos/{id}` | 204 or 404 |

**Useful snippets:**
```java
// 201 Created
ResponseEntity.status(HttpStatus.CREATED).body(created);

// 200 or 404
service.findById(id)
    .map(ResponseEntity::ok)
    .orElse(ResponseEntity.notFound().build());

// 204 or 404
boolean deleted = service.delete(id);
return deleted ? ResponseEntity.noContent().build()
               : ResponseEntity.notFound().build();
```

---

## Run

```bash
mvn spring-boot:run
```

## Test with curl

```bash
# Create
curl -X POST http://localhost:8080/todos \
  -H "Content-Type: application/json" \
  -d '{"title":"Buy milk"}'

# Get all
curl http://localhost:8080/todos

# Get one
curl http://localhost:8080/todos/1

# Delete
curl -X DELETE http://localhost:8080/todos/1
```

---

## Bonus (if you finish early)
- `PUT /todos/{id}` to update title or toggle completed
- `GET /todos?completed=true` to filter the list
