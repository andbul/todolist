package todos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import todos.entities.Todo;
import todos.entities.User;
import todos.repositories.TodoRepository;
import todos.repositories.UserRepository;

/**
 * Created by andrey on 10.11.15.
 */
@Transactional("todosTransactionManager")
@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;
    @Autowired
    UserRepository userRepository;

    @Transactional
    public void addTodo(Todo todo, String login)
    {
        User user = userRepository.findByLogin(login).get();
        todo.setUser(user);
        todoRepository.save(todo);
    }
    @Transactional
    public void deleteTodo(Todo todo){
        todoRepository.delete(todo);
    }
}

