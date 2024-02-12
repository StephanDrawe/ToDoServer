package com.revature.controllers;

import com.revature.models.ToDo;
import com.revature.services.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/todo") //path is now http://localhost:8080/todo
public class ToDoController {

//    dependency injection for service classes

    private ToDoService todolist;
    public ToDoController (ToDoService todolist){
        this.todolist = todolist;
    }


//    handlers for creating todolist records (POST, GET, PUT, DELETE)
//      POST(create a new to-do)

    @PostMapping
    public ToDo createNewToDo(@RequestBody ToDo toDo){
        return todolist.createNewTODO(toDo);
    }

//      GET(view all to-dos)
    @GetMapping
    public List<ToDo> getAllToDos(){
        return todolist.getAllToDos();
    }

//      GET(view single to-do by ID)
    @GetMapping("{id}")
    public ResponseEntity<ToDo> getToDoByID(@PathVariable int id){
        try{
            ToDo returnedToDo = todolist.getToDoById(id);
            return new ResponseEntity<>(returnedToDo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

//      PUT(update a do-to)
    @PutMapping("{id}")
    public ResponseEntity<ToDo> updateToDoByID(@PathVariable int id, @RequestBody ToDo toDo){
        try {
            ToDo returnedToDo = todolist.updateToDoById(id, toDo);
            return new ResponseEntity<>(returnedToDo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

//      DELETE(delete a do-to by ID)
    @DeleteMapping("{id}")
    public ResponseEntity<ToDo> deleteToDoByID(@PathVariable int id){
        try {
            ToDo returnedToDo = todolist.deleteToDoById(id);
            return new ResponseEntity<>(returnedToDo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

//    OPTIONAL ITEMS
//      create account that holds user to-dos
//      login to account
//      view to-dos on a single account
//      filter to-dos to only show completed or uncompleted ones
//      filter to-dos by topic
//    MORE OPTIONAL
//      give account roles(user or admin)
//      JUnit test service layer methods
//      SQL Server database


}
