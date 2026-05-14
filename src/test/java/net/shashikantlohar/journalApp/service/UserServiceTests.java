package net.shashikantlohar.journalApp.service;

import net.shashikantlohar.journalApp.entity.User;
import net.shashikantlohar.journalApp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testSaveNewUser() {
        User user = User.builder().userName("ram").password("plain-password").build();

        assertTrue(userService.saveNewUser(user));

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();
        assertEquals("ram", savedUser.getUserName());
        assertNotEquals("plain-password", savedUser.getPassword());
        assertEquals("USER", savedUser.getRoles().get(0));
    }

    @Test
    public void testSaveNewUserReturnsFalseWhenRepositoryFails() {
        User user = User.builder().userName("ram").password("plain-password").build();
        when(userRepository.save(user)).thenThrow(new RuntimeException("database unavailable"));

        assertFalse(userService.saveNewUser(user));
    }
}
