package com.example.todoibm.service;

import com.example.todoibm.domain.Todo;
import com.example.todoibm.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TodoRepository todoRepository;

    public void instanciaBancoDeDados() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Todo t1 = new Todo(null, "Trabalhar", "Bater a meta", sdf.parse("07/08/2023"), false);
        Todo t2 = new Todo(null, "Estudar", "Java", sdf.parse("10/08/2023"), false);
        Todo t3 = new Todo(null, "Limpar a casa", "Limpar toda a casa", sdf.parse("04/08/2023"), true);
        todoRepository.saveAll(Arrays.asList(t1, t2, t3));

    }

}
