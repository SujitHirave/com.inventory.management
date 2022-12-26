package com.inventory.management.service;

import com.inventory.management.model.AppUser;

public interface AppUserService {
	
	
	public AppUser registerNewUser(AppUser appusers);
	
	public void initRoleAndUser();
	
////		Registration for Admin and User
//		public AppUser registerUser(AppUser appusers);
//			
//	// Login
//		public AppUser login(AppUser appUser); 		
//
//	// logout
//		public String logout(); 		
//
//	// login status
//		public AppUser loginStatus();
//			

	

}
