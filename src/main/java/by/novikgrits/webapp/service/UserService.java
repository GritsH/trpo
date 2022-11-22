package by.novikgrits.webapp.service;

import by.novikgrits.webapp.model.User;
import by.novikgrits.webapp.repository.UserRepository;
import by.novikgrits.webapp.repository.UserRoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    public Optional<User> findByEmail(String email) {
        Optional<User> foundUser = userRepository.findByEmail(email);
        foundUser.ifPresent(user -> user.setEmail(email));
        return foundUser;
    }

    public void addUser(User user) throws SQLException {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setRoleName(userRoleRepository.findByRoleId(1));
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }
}
