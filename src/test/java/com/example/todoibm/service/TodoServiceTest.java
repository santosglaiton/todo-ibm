package com.example.todoibm.service;

import com.example.todoibm.domain.Todo;
import com.example.todoibm.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    public void testFindById(){
        //cenario
        Integer id = 1;
        Todo todo = new Todo();
        todo.setId(id);

        when(todoRepository.findById(id)).thenReturn(Optional.of(todo));
        // quando for chamado o todoRepository pelo método findById, entao me retorna Optinal do obj que eu quero testar

        //execucao
        Todo result = todoService.findById(id);

        //verificacao
        //assert é - verifica se o primeiro objeto é igual ao segundo
        assertEquals(todo,result);
        //verifica se o todoRepository foi chamado só uma vez quando eu chamei o método findById

        verify(todoRepository, times(1)).findById(id);

    }

}
