package com.toyspring.noticeBoard.service;

import com.toyspring.noticeBoard.Entity.Todo;
import com.toyspring.noticeBoard.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo newWrite(Todo todo) {

        Todo createTodo = todo;


        return todoRepository.save(createTodo);
    }

    @Override
    public Todo patch(Todo todo) {
        Todo findTodo = todo;
        findTodo.getTodoId();
        findTodo.setContents(todo.getContents());
        return todoRepository.save(findTodo);
    }

    @Override
    public Todo search(Long todoId) {
        Optional<Todo> todo = todoRepository.findById(todoId);

        Todo findTodo = todo.orElseThrow(() -> new NoSuchElementException());

        return findTodo ;
    }

    public List<Todo> searchAll() {

        List<Todo> findTodo = todoRepository.findAll();

        System.out.println("findTodo = " + findTodo);

        return findTodo;
    }

    @Override
    public void deleteTodo(Long todoId) {
       todoRepository.deleteById(todoId);
    }
}
