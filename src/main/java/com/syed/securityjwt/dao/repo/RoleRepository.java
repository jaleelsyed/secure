package com.syed.securityjwt.dao.repo;

import com.syed.securityjwt.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
