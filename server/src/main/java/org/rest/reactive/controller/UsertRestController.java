package org.rest.reactive.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rest.reactive.User;
import org.rest.reactive.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("users")
@RequiredArgsConstructor
public class UsertRestController {
    private final UserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<User> getUsers(@PathVariable("id") String userId ){
        var user = userService.getUsers(userId);
        return ResponseEntity.ok(user);
    }
}
