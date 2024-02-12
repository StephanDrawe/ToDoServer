package com.revature.DAOs;

import com.revature.models.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoDAO extends JpaRepository<ToDo, Integer> {

    List<ToDo> findAllByIsFinished(boolean isFinished);
}
