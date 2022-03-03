package com.example.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ToDoServiceTest {

    @Autowired
    public ToDoRepository toDoRepository;

    @Test
    void getAllToDos(){
        ToDo toDoSample = new ToDo("ToDo sample 1", true);
        toDoRepository.save(toDoSample);
        ToDoService toDoService = new ToDoService(toDoRepository);

        List<ToDo> toDoList = toDoService.findAll();
        ToDo lastToDo = toDoList.get(toDoList.size() - 1 );

        assertEquals(toDoSample.getText(), lastToDo.getText());
        assertEquals(toDoSample.isCompleted(), lastToDo.isCompleted());
        assertEquals(toDoSample.getId(), lastToDo.getId());
    }

}
