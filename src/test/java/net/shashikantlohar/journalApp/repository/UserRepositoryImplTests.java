package net.shashikantlohar.journalApp.repository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;

import net.shashikantlohar.journalApp.entity.User;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryImplTests {

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private UserRepositoryImpl userRepository;

    @Test
    void testGetUserForSA() {
        when(mongoTemplate.find(any(), any())).thenReturn(Collections.singletonList(User.builder().userName("ram").password("pass").build()));

        Assertions.assertEquals(1, userRepository.getUserForSA().size());
    }
}
