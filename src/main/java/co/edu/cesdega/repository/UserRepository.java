package co.edu.cesdega.repository;
import co.edu.cesdega.models.User;
import java.util.List;

public interface UserRepository {
    User save(User user);
    List<User> findAll();
    User findByUsername(String username);
}