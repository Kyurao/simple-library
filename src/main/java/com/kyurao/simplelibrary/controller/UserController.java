package com.kyurao.simplelibrary.controller;

import com.kyurao.simplelibrary.dto.request.NewUserReq;
import com.kyurao.simplelibrary.dto.request.UserReq;
import com.kyurao.simplelibrary.dto.response.UserRes;
import com.kyurao.simplelibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{id}") //localhost:8800/user/1
    public UserRes getUser(@PathVariable("id") Long userId) {
        return userService.getUser(userId);
    }

    @GetMapping("all")
    public List<UserRes> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("create")
    public void createNewUser(@RequestBody NewUserReq req) {
        userService.addNewUser(req);
    }

    @PutMapping("update/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody UserReq req) {
        userService.editUser(id, req);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
