package com.example.todoibm.controller;

import com.example.todoibm.domain.Todo;
import com.example.todoibm.service.TodoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@WebMvcTest(TodoControllerTest.class)
public class TodoControllerTest {

    @Mock
    private TodoService todoService;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private TodoController todoController;


    @Test
    public void testFindById() throws Exception{
        // cenario
        Integer id = 1;
        Todo todo = new Todo();
        todo.setId(id);
        when(todoService.findById(id)).thenReturn(todo);

        //execucao
        ResponseEntity<Todo> responseEntity = todoController.findById(id);

        //validacao
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(todo, responseEntity.getBody());
        verify(todoService, times(1)).findById(id);
    }

    @Test
    public void testFindAllOpen(){
        Todo todo1 = new Todo();
        Todo todo2 = new Todo();

        when(todoService.findAllOpen()).thenReturn(Arrays.asList(todo1, todo2));

        ResponseEntity<List<Todo>> responseEntity = todoController.findOpen();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, responseEntity.getBody().size());
        verify(todoService, times(1)).findAllOpen();
    }

}
