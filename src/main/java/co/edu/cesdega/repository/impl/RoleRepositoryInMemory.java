package co.edu.cesdega.repository.impl;

import co.edu.cesdega.models.Role;
import co.edu.cesdega.repository.RoleRepository;
import java.util.ArrayList;
import java.util.List;

public class RoleRepositoryInMemory implements RoleRepository {
    private final List<Role> roles = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public Role save(Role role) {
        if (role.getId() == null) {
            role.setId(currentId++);
        }
        roles.add(role);
        return role;
    }

    @Override
    public List<Role> findAll() {
        return roles;
    }

    @Override
    public Role findById(Long id) {
        return roles.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}