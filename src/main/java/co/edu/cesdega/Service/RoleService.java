package co.edu.cesdega.Service;
import co.edu.cesdega.models.Role;
import java.util.List;

public interface RoleService {
    Role save(Role role);
    List<Role> findAll();
}