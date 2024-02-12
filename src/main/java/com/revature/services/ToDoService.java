package com.revature.services;

import com.revature.DAOs.ToDoDAO;
import com.revature.models.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

//    dependency injection for DAO and constructor
    private ToDoDAO todolist;
    @Autowired
    public ToDoService(ToDoDAO todolist) {
        this.todolist = todolist;
    }

    //  1.POST(create a new to-do)
    public ToDo createNewTODO(ToDo toDo){
        return todolist.save(toDo);
    }

//      2.GET(view all to-dos)
    public List<ToDo> getAllToDos(){
//        List<ToDo> allToDos = todolist.findAll();
        return todolist.findAll();
    }

//      3.GET(view single to-do by ID)
    public ToDo getToDoById(int id){
        Optional<ToDo> returnedToDo = todolist.findById(id);
        return returnedToDo.orElseThrow();
    }

//      4.PUT(update a do-to)
    public ToDo updateToDoById(int id, ToDo toDo){
        Optional<ToDo> possibleReturnedToDo = todolist.findById(id);
        ToDo returnedToDo = possibleReturnedToDo.orElseThrow();

//            returnedToDo = getToDoById(id)
            returnedToDo.setBody(toDo.getBody());
            returnedToDo.setFinished(toDo.getFinished());

            return todolist.save(returnedToDo);

    }

//      5.DELETE(delete a do-to by ID)
    public ToDo deleteToDoById(int id){
        Optional<ToDo> possibleReturnedToDo = todolist.findById(id);
        ToDo returnedToDo = possibleReturnedToDo.orElseThrow();

        todolist.deleteById(id);

        return returnedToDo;
    }

}
