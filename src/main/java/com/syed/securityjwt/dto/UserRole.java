package com.syed.securityjwt.dto;

import com.syed.securityjwt.dao.entity.Role;
import com.syed.securityjwt.dao.entity.Users;

public class UserRole {

    private long userRoleId;
    private Users user;
    private Role role;
}
