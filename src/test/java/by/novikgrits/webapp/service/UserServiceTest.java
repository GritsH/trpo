package by.novikgrits.webapp.service;

import by.novikgrits.webapp.model.User;
import by.novikgrits.webapp.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @DisplayName("should find user by email")
    @Test
    void findByEmail() {
        User mockedUser = mock(User.class);

        when(userRepository.findByEmail("email")).thenReturn(Optional.of(mockedUser));

        Optional<User> result = userService.findByEmail("email");

        assertEquals(mockedUser, result.get());

        verify(userRepository).findByEmail("email");
        verifyNoMoreInteractions(userRepository);
    }

    @DisplayName("should add new user")
    @Test
    void addUser() {
        User user = new User("role", "name",
                "surname", "email",
                "pass", 111, "passport data");

        userService.addUser(user);

        verify(userRepository).save(user);
        verifyNoMoreInteractions(userRepository);
    }
}