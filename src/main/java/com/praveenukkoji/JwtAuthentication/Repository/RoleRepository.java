package com.praveenukkoji.JwtAuthentication.Repository;

import com.praveenukkoji.JwtAuthentication.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Long> {

    Role findByRolename(String rolename);
}
