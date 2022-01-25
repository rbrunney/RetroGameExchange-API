package com.example.retrovideogameexchangeapi.endpoint_controllers;

import com.example.retrovideogameexchangeapi.endpoint_blls.UserBLL;
import com.example.retrovideogameexchangeapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="users")
public class UserController {

    @Autowired
    private UserBLL userBLL;

    /////////// Endpoints //////////////////////////////////////
    @GetMapping(path="/{id}")
    @ResponseStatus(code=HttpStatus.OK)
    public User getUser(@RequestHeader(value="Authorization") String authHead, @PathVariable int id) {
        return userBLL.getUserInfo(authHead, id);
    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteUser(@RequestHeader(value="Authorization") String authHead, @PathVariable int id) {
        userBLL.deleteUser(authHead, id);
    }

    @PostMapping(path = "/createUser")
    @ResponseStatus(code= HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userBLL.createUser(user);
    }

    @GetMapping(path="/forgotPassword")
    @ResponseStatus(code=HttpStatus.OK)
    public void sendTemporaryPassword(@RequestHeader(value="Authorization") String authHead) {
        userBLL.forgotPassword(authHead);
    }

    @PatchMapping(path="/updateName")
    @ResponseStatus(code=HttpStatus.OK)
    public User changeName(@RequestHeader(value="Authorization") String authHead, @RequestParam String newName) {
        return userBLL.changeName(authHead, newName);
    }

    @PatchMapping(path="/updateAddress")
    @ResponseStatus(code=HttpStatus.OK)
    public User changeAddress(@RequestHeader(value="Authorization") String authHead, @RequestParam String address) {
        return userBLL.updateAddress(authHead, address);
    }

    @PatchMapping(path="/changePassword")
    @ResponseStatus(code=HttpStatus.OK)
    public User changePassword(@RequestHeader(value="Authorization") String authHead, @RequestParam String newPass) {
        return userBLL.changePassword(authHead, newPass);
    }


}
