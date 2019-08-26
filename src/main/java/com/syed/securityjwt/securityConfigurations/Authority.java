package com.syed.securityjwt.securityConfigurations;

import com.syed.securityjwt.dao.entity.Users;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;

import java.io.Serializable;

public class Authority implements GrantedAuthority, Serializable {

    public static final Long serializableVersionID = 123123L;

    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public static Long getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        Users user= (Users) authentication.getPrincipal();
        return user.getId();
    }
}
