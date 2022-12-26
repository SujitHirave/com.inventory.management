package com.inventory.management.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.inventory.management.model.AppUser;
import com.inventory.management.model.Role;
import com.inventory.management.service.AppUserService;
import com.inventory.management.repository.AppUserRepository;
import com.inventory.management.repository.RoleRepository;

/**
 * 
 * 
 * Service for Registration, Login and Logout functionalities
 *
 */

@Service
public class AppUserServiceImpl implements AppUserService {

	private static final Logger LOG = LoggerFactory.getLogger(AppUserService.class);

	@Autowired
	private AppUserRepository repository;

	@Autowired
	private RoleRepository roleDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private AppUser currentAppUser; // access control to APIs
    
	//initRoleAndUser
	@Override
	public void initRoleAndUser() {
		LOG.info("AppUserServiceImpl-initRoleAndUser");
		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for newly created record");
		roleDao.save(userRole);


	}
	
    //registerNewUser
	@Override
	public AppUser registerNewUser(AppUser user) {
		LOG.info("AppUserServiceImpl-registerNewUser");
		Role role = roleDao.findById("User").get();
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(role);
		user.setRole(userRoles);
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));

		return repository.save(user);
	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

////	Registration for Admin and User
//	@Transactional
//	@Override
//	public AppUser registerUser(AppUser appusers) {
//		LOG.info("Registered Successfully");
//		return repository.save(appusers);
//	}
//
//// Login
//	@Transactional
//	@Override
//	public AppUser login(AppUser Appuser) {
//		LOG.info("LoginService");
////		currentAppuser = loginRepository.findByEmail(Appuser.getEmail());
//		currentAppUser = repository.findByEmailAndPassword(Appuser.getEmail(), Appuser.getuserPassword());
//		return currentAppUser;
//	}
//
//// logout
//	@Transactional
//	@Override
//	public String logout() {
//		LOG.info("logoutService");
//		currentAppUser = null;
//		return " Logged out successfully";
//	}
//
//// login status
//	@Transactional
//	@Override
//	public AppUser loginStatus() {
//		LOG.info("loginStatusService");
//		return currentAppUser;
//	}

}