package com.snack.learning.spring.autowired;

public class UserController {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }
}
