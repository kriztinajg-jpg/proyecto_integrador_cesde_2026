package co.edu.cesdega.Service.impl;

import co.edu.cesdega.models.Role;
import co.edu.cesdega.repository.RoleRepository;
import co.edu.cesdega.Service.RoleService;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}