package com.toyspring.noticeBoard.service;

import com.toyspring.noticeBoard.Entity.Todo;
import java.util.List;


public interface TodoService {

    public Todo newWrite(Todo todo);

    public Todo patch(Todo todo);

    public Todo search(Long todoId);

    public List<Todo> searchAll();

    public void deleteTodo(Long todoId);
}
