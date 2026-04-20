package co.edu.cesdega.Service.impl;

import co.edu.cesdega.models.User_role;
import co.edu.cesdega.repository.UserRoleRepository;
import co.edu.cesdega.Service.UserRoleService;
import java.util.List;

public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public User_role save(User_role userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public List<User_role> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public List<User_role> findByUserId(Long userId) {
        return userRoleRepository.findByUserId(userId);
    }
}