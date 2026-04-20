package co.edu.cesdega.Service.impl;
import co.edu.cesdega.models.User;
import co.edu.cesdega.repository.UserRepository;
import co.edu.cesdega.Service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) { return userRepository.save(user); }

    @Override
    public List<User> findAll() { return userRepository.findAll(); }
}