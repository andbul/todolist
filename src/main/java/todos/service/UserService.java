package todos.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by andrey on 10.11.15.
 */
@Service
@Transactional("todosTransactionManager")
public class UserService {

}
