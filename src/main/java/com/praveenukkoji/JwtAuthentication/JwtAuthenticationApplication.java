package com.praveenukkoji.JwtAuthentication;

import com.praveenukkoji.JwtAuthentication.Model.AppUser;
import com.praveenukkoji.JwtAuthentication.Model.Role;
import com.praveenukkoji.JwtAuthentication.Service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtAuthenticationApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner runner(AppUserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null, "Praveen", "praveen", "praveen",
					new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Prem", "prem", "prem",
					new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Pratik", "pratik", "pratik",
					new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Rohit", "rohit", "rohit",
					new ArrayList<>()));

			userService.addRoleToAppUser("praveen", "ROLE_SUPER_ADMIN");
			userService.addRoleToAppUser("praveen", "ROLE_ADMIN");
			userService.addRoleToAppUser("praveen", "ROLE_MANAGER");
			userService.addRoleToAppUser("praveen", "ROLE_USER");

			userService.addRoleToAppUser("prem", "ROLE_ADMIN");

			userService.addRoleToAppUser("pratik", "ROLE_MANAGER");

			userService.addRoleToAppUser("rohit", "ROLE_USER");

		};
	}
}
