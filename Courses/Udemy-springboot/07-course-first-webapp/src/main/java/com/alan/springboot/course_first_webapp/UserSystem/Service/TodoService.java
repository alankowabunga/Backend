package com.alan.springboot.course_first_webapp.UserSystem.Service;

import com.alan.springboot.course_first_webapp.UserSystem.Model.Todo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static Long id = 0L;
    private static List<Todo> todos = new ArrayList<>();
    // initialize datas
    static{
        todos.add(new Todo(++id,"alan","complete tutorial", LocalDate.now().minusWeeks(2),false));
        todos.add(new Todo(++id,"tanya","learn English", LocalDate.now(),false));
        todos.add(new Todo(++id,"nobody","help john", LocalDate.now().minusDays(3),false));
    }

    public List<Todo> findAllTodo(){
        return todos;
    }

//    public void add(String username , String description){
//        Todo todo = new Todo(++id,username,description,LocalDate.now().plusWeeks(3),false);
//        todos.add(todo);
//    }

    public void deleteById(Long id) {

        // define Predicate
        Predicate<? super Todo> isTargetTodo = todo  -> todo.getId() == id ;
        // remove
        todos.removeIf(isTargetTodo);
    }

    public Todo findById(Long id) {

        Predicate<? super Todo> isTargetTodo = todo -> todo.getId() == id;
        return todos.stream().filter(isTargetTodo).findFirst().get();
    }

    public List<Todo> findByUsername(String username) {

        Predicate<? super Todo> isTargetTodo = todo -> todo.getUsername().equals(username);
        return todos.stream().filter(isTargetTodo).toList();
    }

    public void update(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }

    public void add(String username, String description, LocalDate deadline, boolean done) {

    }
}
