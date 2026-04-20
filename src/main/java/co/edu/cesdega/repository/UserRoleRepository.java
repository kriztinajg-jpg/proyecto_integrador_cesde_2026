package co.edu.cesdega.repository;

import co.edu.cesdega.models.User_role;
import java.util.List;

public interface UserRoleRepository {
    User_role save(User_role userRole);
    List<User_role> findAll();
    List<User_role> findByUserId(Long userId);
}