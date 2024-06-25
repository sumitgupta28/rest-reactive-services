package org.rest.reactive.controller;

import lombok.RequiredArgsConstructor;
import org.rest.reactive.User;
import org.rest.reactive.services.UserClientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestConroller {
    private final UserClientService userClientService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) // http://localhost:8080/user?id=1,2,3 or
    // http://localhost:8080/user??id=1&id=2
    @ResponseBody
    List<User> messages(@RequestParam(name = "id") List<String> id){
        return userClientService.fetchUsers(id);
    }
}
