package com.company.service;

import com.company.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto create(Long id,UserDto airportDto);


    UserDto update(UserDto airportDto);


    void delete(Long id);



}
