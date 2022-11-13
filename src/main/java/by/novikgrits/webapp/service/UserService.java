package by.novikgrits.webapp.service;

import by.novikgrits.webapp.model.User;
import by.novikgrits.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    public Optional<User> findByEmail(String email) {
        Optional<User> foundUser = userRepository.findByEmail(email);
        foundUser.ifPresent(user -> user.setEmail(email));
        return foundUser;
    }

    public void addUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }
}
