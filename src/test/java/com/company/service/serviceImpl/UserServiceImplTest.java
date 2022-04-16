package com.company.service.serviceImpl;

import com.company.dto.UserDto;
import com.company.model.User;
import com.company.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void getAll() {
        User user = User.builder()
                .firstName("Cavansir")
                .build();
        List<User> userList = Mockito.spy(ArrayList.class);
        userList.add(user);
        Mockito.when(userRepository.findAll()).thenReturn(userList);

        Assertions.assertDoesNotThrow(() -> userService.getAll());
    }

    @Test
    void create() {
        User user = User.builder()
                .id(1L)
                .firstName("Elnur")
                .build();
        Mockito.when(userRepository.save(user)).thenReturn(user);

        Assertions.assertDoesNotThrow(() -> userService.create(1L, modelMapper.map(user, UserDto.class)));
    }

    @Test
    void update() {
        UserDto userDto = UserDto.builder()
                .id(2L)
                .firstName("MMm")
                .build();

        Assertions.assertDoesNotThrow(() -> userService.create(1L, new UserDto(userDto)));
    }

    @Test
    void delete() {

        UserDto userDto = UserDto.builder()
                .id(2L)
                .build();

        Assertions.assertDoesNotThrow(() -> userService.delete(userDto.getId()));
    }
}