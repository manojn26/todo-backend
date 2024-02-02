package com.todo.backend.controller;

import com.todo.backend.dto.TodoDto;
import com.todo.backend.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class AllController {

    @Autowired
//    private UserService userService;
    private TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto todoDto){

        TodoDto savedTodo = todoService.createTodo(todoDto);

        return  new ResponseEntity<>(savedTodo,HttpStatus.CREATED);
    }

//    Get Todo By Id
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable("id") Long id){
        TodoDto todoDto = todoService.getTodoById(id);
        return  ResponseEntity.ok(todoDto);
    }

//    Get All Todos
    @GetMapping("/all")
    public ResponseEntity<List<TodoDto>> getAllTodos(){
        List<TodoDto> allTodos = todoService.getAllTodos();

        return ResponseEntity.ok(allTodos);
    }

//    Update Todo
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable("id") Long id, @RequestBody TodoDto updatedTodo){
        TodoDto todoDto = todoService.updateTodo(id,updatedTodo);
        return  ResponseEntity.ok(todoDto);
    }

    @PutMapping("/completed/{id}")
    public  ResponseEntity<String> updateIsCompleted(@PathVariable("id") Long id, @RequestBody TodoDto todoDto){
        todoService.markAsCompleted(id,todoDto);
        return ResponseEntity.ok("All Ok");
    }

//    Delete Todo
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id){
        todoService.deleteTodo(id);

        return ResponseEntity.ok("Todo Deleted Succesfully");
    }

}
