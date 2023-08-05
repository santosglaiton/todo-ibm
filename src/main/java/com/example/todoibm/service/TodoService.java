package com.example.todoibm.service;

import com.example.todoibm.domain.Todo;
import com.example.todoibm.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {


    @Autowired
    private TodoRepository todoRepository;


    public Todo findById(Integer id){
        Optional<Todo> obj = todoRepository.findById(id);
        return obj.orElse(null);
    }

    public List<Todo> findAllOpen() {

        List<Todo> list = todoRepository.findAllOpen();
        return list;

    }
}
