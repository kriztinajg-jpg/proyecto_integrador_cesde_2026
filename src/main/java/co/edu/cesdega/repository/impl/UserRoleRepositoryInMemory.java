package co.edu.cesdega.repository.impl;

import co.edu.cesdega.models.User_role;
import co.edu.cesdega.repository.UserRoleRepository;
import java.util.ArrayList;
import java.util.List;

public class UserRoleRepositoryInMemory implements UserRoleRepository {
    private final List<User_role> userRoles = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public User_role save(User_role userRole) {
        if (userRole.getUserRoleId() == null) {
            userRole.setUserRoleId(currentId++);
        }
        userRoles.add(userRole);
        return userRole;
    }

    @Override
    public List<User_role> findAll() {
        return userRoles;
    }

    @Override
    public List<User_role> findByUserId(Long userId) {
        List<User_role> result = new ArrayList<>();
        for (User_role ur : userRoles) {
            if (ur.getUser() != null && ur.getUser().getUserId().equals(userId)) {
                result.add(ur);
            }
        }
        return result;
    }
}