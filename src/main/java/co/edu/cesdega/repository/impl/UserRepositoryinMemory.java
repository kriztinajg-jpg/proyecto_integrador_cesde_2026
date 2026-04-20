package co.edu.cesdega.repository.impl;

import co.edu.cesdega.models.User;
import co.edu.cesdega.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryinMemory implements UserRepository {
    private final List<User> users = new ArrayList<>();
    private Long currentId = 1L;

    @Override
    public User save(User user) {

        if (user.getUserId() == null) {
            user.setUserId(currentId++);
        }
        users.add(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findByUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
}