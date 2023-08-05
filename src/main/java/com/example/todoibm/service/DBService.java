package com.example.todoibm.service;

import com.example.todoibm.domain.Todo;
import com.example.todoibm.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TodoRepository todoRepository;

    public void instanciaBancoDeDados(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Todo t1 = new Todo(null, "Trabalhar", "Bater a meta", LocalDateTime.parse("07/08/2023 11:00", formatter), false);
        Todo t2 = new Todo(null, "Estudar", "Java", LocalDateTime.parse("10/08/2023 12:00", formatter), false);
        Todo t3 = new Todo(null, "Limpar a casa", "Limpar toda a casa", LocalDateTime.parse("04/08/2023 13:00", formatter), true);
        todoRepository.saveAll(Arrays.asList(t1, t2, t3));

    }

}
