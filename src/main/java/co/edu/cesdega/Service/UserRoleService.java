package co.edu.cesdega.Service;

import co.edu.cesdega.models.User_role;
import java.util.List;

public interface UserRoleService {
    User_role save(User_role userRole);
    List<User_role> findAll();
    List<User_role> findByUserId(Long userId);
}