package co.edu.cesdega.repository;

import co.edu.cesdega.models.Role;
import java.util.List;

public interface RoleRepository {
    Role save(Role role);
    List<Role> findAll();
    Role findById(Long id);
}