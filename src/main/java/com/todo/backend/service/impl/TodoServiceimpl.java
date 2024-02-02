package com.todo.backend.service.impl;

import com.todo.backend.dto.TodoDto;
import com.todo.backend.dto.mapper.TodoMapper;
import com.todo.backend.entity.Todo;
import com.todo.backend.repository.ResourceNotFoundException;
import com.todo.backend.repository.TodoRepository;
import com.todo.backend.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceimpl implements TodoService {
    private TodoRepository todoRepository;
    @Override
    public TodoDto createTodo(TodoDto todoDto) {
        Todo todo = TodoMapper.mapToTodo(todoDto);
        Todo savedTodo = todoRepository.save(todo);

        return TodoMapper.mapTodoDto(savedTodo);
    }

    @Override
    public TodoDto getTodoById(Long id) {

        Todo todo  =todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Present"));

        return TodoMapper.mapTodoDto(todo);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> allTodos = todoRepository.findAll();

        return allTodos.stream().map((employee) -> TodoMapper.mapTodoDto(employee)).collect(Collectors.toList());




    }

    @Override
    public TodoDto updateTodo(Long id, TodoDto todoDto) {
        Todo todos =todoRepository.findById(id).orElseThrow(
                () ->new ResourceNotFoundException("Resource Not Found")
        );

        todos.setTodoTitle(todoDto.getTodoTitle());
        todos.setTodoIsCompleted(todoDto.isTodoIsCompleted());

        Todo updateTodoObj = todoRepository.save(todos);

        return TodoMapper.mapTodoDto(updateTodoObj);
    }

    @Override
    public void markAsCompleted(Long id,TodoDto todoDto) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource Not Found")
        );

        todo.setTodoIsCompleted(todoDto.isTodoIsCompleted());
        Todo updateTodoObj = todoRepository.save((todo));

    }

    @Override
    public void deleteTodo(Long id) {
        Todo todos =todoRepository.findById(id).orElseThrow(
                () ->new ResourceNotFoundException("Todo Not Found")
        );

        todoRepository.deleteById(id);
    }
}
