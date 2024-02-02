package com.todo.backend.dto.mapper;

import com.todo.backend.dto.TodoDto;
import com.todo.backend.entity.Todo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TodoMapper {
    static SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

//    MapTodo JPA intoTodo DTO
    public static TodoDto mapTodoDto(Todo todo){
            return new TodoDto(
                    todo.getId(),
                    todo.getTodoTitle(),
                    todo.isTodoIsCompleted()
            );
    }

//    Map TODODto Into TodoJpa
    public static Todo mapToTodo(TodoDto todoDto){
        return  new Todo(
                todoDto.getId(),
                todoDto.getTodoTitle(),
                todoDto.isTodoIsCompleted()
        );
    }
}
