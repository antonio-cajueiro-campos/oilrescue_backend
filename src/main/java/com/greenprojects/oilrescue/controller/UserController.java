package com.greenprojects.oilrescue.controller;

import com.greenprojects.oilrescue.model.dto.UserDTO;
import com.greenprojects.oilrescue.model.entity.UserEntity;
import com.greenprojects.oilrescue.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("get/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @PostMapping("save")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserDTO user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("user/save").toString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PutMapping("update")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserDTO user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("delete")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
