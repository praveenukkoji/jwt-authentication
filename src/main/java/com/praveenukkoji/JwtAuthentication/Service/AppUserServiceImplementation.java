package com.praveenukkoji.JwtAuthentication.Service;

import com.praveenukkoji.JwtAuthentication.Model.AppUser;
import com.praveenukkoji.JwtAuthentication.Model.Role;
import com.praveenukkoji.JwtAuthentication.Repository.RoleRepository;
import com.praveenukkoji.JwtAuthentication.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImplementation implements AppUserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving new user {} to the database", user.getName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getRolename());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToAppUser(String username, String rolename) {
        log.info("Adding role {} to user {}", rolename, username);
        AppUser user = userRepository.findByUsername(username);
        Role role = roleRepository.findByRolename(rolename);
        user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
