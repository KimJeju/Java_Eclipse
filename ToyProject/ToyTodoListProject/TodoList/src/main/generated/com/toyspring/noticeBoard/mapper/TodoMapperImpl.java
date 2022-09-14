package com.toyspring.noticeBoard.mapper;

import com.toyspring.noticeBoard.Entity.Todo;
import com.toyspring.noticeBoard.dto.TodoPatchDto;
import com.toyspring.noticeBoard.dto.TodoPostDto;
import com.toyspring.noticeBoard.dto.TodoResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-22T14:28:11+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class TodoMapperImpl implements TodoMapper {

    @Override
    public Todo todoPostDtoToTodo(TodoPostDto todoPostDto) {
        if ( todoPostDto == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.setTitle( todoPostDto.getTitle() );
        todo.setContents( todoPostDto.getContents() );

        return todo;
    }

    @Override
    public Todo todoPatchDtoToTodo(TodoPatchDto todoPatchDto) {
        if ( todoPatchDto == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.setTodoId( todoPatchDto.getTodoId() );
        todo.setTitle( todoPatchDto.getTitle() );
        todo.setContents( todoPatchDto.getContents() );
        todo.setModifiedAt( todoPatchDto.getModifiedAt() );

        return todo;
    }

    @Override
    public TodoResponseDto todoToTodoResponseDto(Todo todo) {
        if ( todo == null ) {
            return null;
        }

        Long todoId = null;
        String title = null;
        String contents = null;

        todoId = todo.getTodoId();
        title = todo.getTitle();
        contents = todo.getContents();

        TodoResponseDto todoResponseDto = new TodoResponseDto( todoId, title, contents );

        return todoResponseDto;
    }
}
