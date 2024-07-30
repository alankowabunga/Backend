package com.alan.springboot.course_first_webapp.UserSystem.Controller;

import com.alan.springboot.course_first_webapp.UserSystem.Model.Todo;
import com.alan.springboot.course_first_webapp.UserSystem.Repository.TodoRepository;
import com.alan.springboot.course_first_webapp.UserSystem.Service.AuthService;
import com.alan.springboot.course_first_webapp.UserSystem.Service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
//@SessionAttributes("username")
public class TodoController {
    private TodoService todoService = new TodoService();
    @Autowired
    private TodoRepository todoRepository ;
    public TodoController( TodoRepository todoRepository) {
//        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    private AuthService authService = new AuthService();
    @GetMapping("todoPage")
    public String todoPage(ModelMap modelMap){
        String username = authService.getLoggedUser();
        modelMap.put("username",username);

        //TODO:use database
//        List<Todo> todos = todoService.findByUsername(username);

        List<Todo> todos = todoRepository.findTodosByUsername(username);

        modelMap.put("todos",todos);
        return "ListTodo";
    }

    /*
    需要将 Todo 对象添加到模型中，以便在 JSP 中使用。
    * */
    @GetMapping("addNewTodo")
    public String AddNewTodoPage(ModelMap modelMap){

        String username = new AuthService().getLoggedUser();
        Todo todo = new Todo(0L,username,"", LocalDate.now(),false);
        modelMap.put("todo",todo); // form:form modelAttribute("todo")

        return "AddNewTodo";
    }

    /*
    RequestParam desciption: 對應到 input:name 屬性
    Todo todo 對應到 form:form modelAttribute(雙向綁定)
    * */
    @PostMapping("addNewTodo")
    public String doAddNewTodo(ModelMap modelMap, @Valid @ModelAttribute("todo") Todo todo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "AddNewTodo";
        }
        String username = new AuthService().getLoggedUser();

//        todoService.add(username, todo.getDescription(),todo.getDeadline(),todo.isDone());

        //save to database
        todo.setUsername(username);
        todoRepository.save(todo);

        return "redirect:todoPage";
    }

    @RequestMapping("deleteTodo")
    public String deleteTodo(@RequestParam("id") Long id){

//        todoService.deleteById(id);

        todoRepository.deleteById(id);

        return "redirect:todoPage";
    }

    @GetMapping("updateTodoPage")
    public String updateTodoPage(@RequestParam("id") Long id,ModelMap modelMap){

        // put todo's data into model for jsp
//        Todo targetTodo = todoService.findById(id);

        Todo targetTodo = todoRepository.findById(id).get();

        modelMap.addAttribute("todo",targetTodo);
        return "AddNewTodo";
    }
    // command bean: 透過 modelAttribute 取得 todo 對象
    @PostMapping("updateTodoPage")
    public String doUpdateTodo(@Valid @ModelAttribute("todo") Todo todo,BindingResult bindingResult,ModelMap modelMap){
        if(bindingResult.hasErrors()){
            return "AddNewTodo";
        }
        String username = new AuthService().getLoggedUser();
        todo.setUsername(username);

//        todoService.update(todo);

        todoRepository.save(todo);

        return "redirect:todoPage";
    }
}
