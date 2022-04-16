package com.company.controller;

import com.company.dto.UserDto;
import com.company.service.UserService;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;

    @Test
    void getAll() {
        UserDto userDto = UserDto.builder()
                .firstName("Elnur")
                .build();
        List<UserDto> userDtoList = Mockito.spy(ArrayList.class);
        userDtoList.add(userDto);
        Mockito.when(userService.getAll()).thenReturn(userDtoList);
        Assertions.assertDoesNotThrow(() -> userController.getAll());
    }

    @Test
    void getById() {
        UserDto userDto = UserDto.builder()
                .id(1L)
                .build();
        List<UserDto> userDtoList = Mockito.spy(ArrayList.class);
        userDtoList.add(userDto);
        Mockito.when(userService.getById(userDto.getId())).thenReturn(userDto);
        Assertions.assertDoesNotThrow(() -> userController.getById(userDto.getId()));
    }

    @Test
    void create() {
        UserDto userDto = UserDto.builder()
                .id(1L)
                .firstName("Elnur")
                .build();
        Mockito.when(userService.create(1L, new UserDto(userDto))).thenReturn(userDto);
        Assertions.assertDoesNotThrow(() -> userController.create(1L, new UserDto(userDto)));
    }

    @Test
    void update() {
        UserDto userDto = UserDto.builder()
                .id(1L)
                .firstName("Elnur")
                .build();
        Assertions.assertDoesNotThrow(() -> userController.update(new UserDto(userDto)));
    }

    @Test
    void delete() {
        UserDto userDto = UserDto.builder()
                .id(1L)
                .build();
        Assertions.assertDoesNotThrow(() -> userController.delete(userDto.getId()));
    }
}