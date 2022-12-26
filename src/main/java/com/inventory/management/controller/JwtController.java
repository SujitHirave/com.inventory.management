package com.inventory.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.inventory.management.model.JwtRequest;
import com.inventory.management.model.JwtResponse;
import com.inventory.management.service.JwtService;

/**
 * 
 * controller for JwtController functionalities
 *
 */
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false"   )
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class JwtController {
	
	private static final Logger LOG = LoggerFactory.getLogger(JwtController.class);


    @Autowired
    private JwtService jwtService;
  
    //createJwtToken
    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
	    LOG.info("LoginController-createJwtToken");
        return jwtService.createJwtToken(jwtRequest);
    }
}
