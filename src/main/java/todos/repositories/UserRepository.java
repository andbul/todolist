package todos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todos.entities.User;

import java.util.Optional;

/**
 * Created by andrey on 10.11.15.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByLogin(String login);
}
