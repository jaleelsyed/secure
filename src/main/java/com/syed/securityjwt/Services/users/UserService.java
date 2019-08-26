package com.syed.securityjwt.Services.users;

import com.syed.securityjwt.dao.entity.UserRole;
import com.syed.securityjwt.dao.entity.Users;
import com.syed.securityjwt.utils.Response;

import java.util.Set;

public interface UserService {
    Response<Users> createUser(Users user, Set<UserRole> userRoles);

    Response<Users> getUser(Long currentAuditor);
}
