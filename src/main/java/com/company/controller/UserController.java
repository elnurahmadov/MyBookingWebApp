package com.company.controller;

import com.company.dto.UserDto;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> all = userService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/list/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping("/create")
    public UserDto create(@RequestParam Long id, @RequestBody UserDto userDto) {
        return userService.create(id, userDto);
    }

    @PutMapping("/update")
    public UserDto update(@RequestBody UserDto userDto) {
        return userService.update(userDto);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }


}