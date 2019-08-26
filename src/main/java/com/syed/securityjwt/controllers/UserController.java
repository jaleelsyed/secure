package com.syed.securityjwt.controllers;

import com.syed.securityjwt.Services.users.UserService;
import com.syed.securityjwt.dao.entity.Users;
import com.syed.securityjwt.securityConfigurations.Authority;
import com.syed.securityjwt.securityConfigurations.SecurityUtility;
import com.syed.securityjwt.utils.Response;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Response<Users> add(@RequestBody Users request) {

        return userService.createUser(request, request.getUserRoles());
    }

    @RequestMapping(value = "/login-status", method = RequestMethod.GET)
    public Response<Users> login() {

        return userService.getUser(Authority.getCurrentAuditor());
    }
}
