package com.todo.backend.service;

import com.todo.backend.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto createTodo(TodoDto todoDto);

    TodoDto getTodoById(Long id);

    List<TodoDto> getAllTodos();

    TodoDto updateTodo(Long id,TodoDto todoDto);

    void markAsCompleted(Long id, TodoDto todoDto);

    void deleteTodo(Long id);

}
