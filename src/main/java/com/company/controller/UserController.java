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


    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> all = userService.getAll();
        return ResponseEntity.ok(all);
    }


    @PostMapping
    public UserDto create(@RequestParam Long id,@RequestBody UserDto userDto) {
        return userService.create(id,userDto);
    }

    @PutMapping
    public UserDto update(@RequestBody UserDto userDto){
        return userService.update(userDto);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }


}
