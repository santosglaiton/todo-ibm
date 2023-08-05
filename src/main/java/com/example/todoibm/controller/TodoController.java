package com.example.todoibm.controller;

import com.example.todoibm.domain.Todo;
import com.example.todoibm.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Integer id){
        Todo obj = todoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/open")
    public ResponseEntity<List<Todo>> findOpen(){
        List<Todo> list = todoService.findAllOpen();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/closed")
    public ResponseEntity<List<Todo>> findClosed(){
        List<Todo> list = todoService.findAllClosed();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Todo>> findAll(){
        List<Todo> list = todoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo obj){
        obj = todoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo obj){
        Todo newObj = todoService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

}
