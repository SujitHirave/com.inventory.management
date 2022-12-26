package com.inventory.management.controller;

/**
 * 
 * controller for Login functionalities
 *
 */

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.inventory.management.model.AppUser;
import com.inventory.management.service.impl.AppUserServiceImpl;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false"   )
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
 
	@Autowired
	private AppUserServiceImpl userService;
	
	//initRoleAndUser
	 @PostConstruct
	    public void initRoleAndUser() {
		    LOG.info("initRoleAndUser");
	        userService.initRoleAndUser();
	    }
	
	 //registerNewUser
	@PostMapping({"/registerNewUser"})
    public AppUser registerNewUser(@RequestBody AppUser user) {
	    LOG.info("LoginController-registerNewUser");
        return userService.registerNewUser(user);
    }


}