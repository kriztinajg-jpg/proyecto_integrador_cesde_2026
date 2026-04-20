package co.edu.cesdega.Service;
import co.edu.cesdega.models.User;
import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
}