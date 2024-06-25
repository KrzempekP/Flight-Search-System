package com.example.flightsearchsystem;


import com.example.flightsearchsystem.model.User;
import com.example.flightsearchsystem.repository.UserRepository;
import com.example.flightsearchsystem.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user1;
    private User user2;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);
        user1 = new User();
        user1.setId(1L);
        user1.setUsername("User1");
        user2 = new User();
        user2.setId(2L);
        user2.setUsername("User2");
    }

    @Test
    public void testAddUser() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> allUsers = userService.getAllUsers();

        assertEquals(2, allUsers.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testGetUserById(){
        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));

        assertEquals(user1, userService.getUserById(1L));
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    public void testSaveUser(){
        when(userRepository.save(user1)).thenReturn(user1);

        assertEquals(user1, userService.saveUser(user1));
        verify(userRepository, times(1)).save(user1);
    }
}
