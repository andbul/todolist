package todos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todos.entities.Todo;
import todos.repositories.TodoRepository;
import todos.repositories.UserRepository;
import todos.service.TodoService;

import java.util.Collection;

/**
 * Created by andrey on 10.11.15.
 */
@RestController
@RequestMapping("/{login}/todos")
public class TodoController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    TodoService todoService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Collection<Todo> getTodos(@PathVariable String login){
        return todoRepository.findByUserLogin(login);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addTodo(@PathVariable String login, @RequestBody Todo todo){
        todoService.addTodo(todo, login);
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteTodo(Todo todo){
        todoService.deleteTodo(todo);
    }
}