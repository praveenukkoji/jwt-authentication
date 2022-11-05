package com.praveenukkoji.JwtAuthentication.Service;

import com.praveenukkoji.JwtAuthentication.Model.AppUser;
import com.praveenukkoji.JwtAuthentication.Model.Role;

import java.util.List;

public interface AppUserService {

    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToAppUser(String username, String rolename);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
