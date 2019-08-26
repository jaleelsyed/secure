package com.syed.securityjwt.Services.users;

import com.syed.securityjwt.dao.entity.UserRole;
import com.syed.securityjwt.dao.entity.Users;
import com.syed.securityjwt.dao.repo.RoleRepository;
import com.syed.securityjwt.dao.repo.UserRepository;
import com.syed.securityjwt.securityConfigurations.SecurityUtility;
import com.syed.securityjwt.utils.Message;
import com.syed.securityjwt.utils.MessageType;
import com.syed.securityjwt.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public Response<Users> createUser(Users user, Set<UserRole> userRoles) {
        Users localUser = userRepository.findByUsername(user.getUsername());
        user.setPassword(SecurityUtility.passwordEncoder().encode(user.getPassword()));
        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        } else {
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);

            localUser = userRepository.save(user);
        }

        return new Response<>(localUser);
    }

    @Override
    public Response<Users> getUser(Long currentAuditor) {
        Optional<Users> localUser = userRepository.findById(currentAuditor);
        if (localUser.isPresent()) {
            return new Response<>(localUser.get());
        } else {
            return new Response<>().withErrors(true).withMessage(new Message(MessageType.ERROR, "", String.format("Current user not exist" + currentAuditor.toString())));

        }
    }
}
