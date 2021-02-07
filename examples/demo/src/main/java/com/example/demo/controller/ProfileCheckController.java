package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.logging.Logger;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */
@RestController
@Api(value="Profile Check controller")
public class ProfileCheckController {
	
//    @SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ProfileCheckController.class.getName());
    
    @Autowired
    private Environment environment;

	@ApiOperation(value="Say which profile is used", hidden = true)
    @GetMapping("/checkProfile")
    public String checkProfile() {
    	String profileString = "No profile(s)";
    	String[] activeProfiles = environment.getActiveProfiles();
    	if(activeProfiles != null && activeProfiles.length > 0) {
    		profileString = "Spring Boot is running under "+ activeProfiles[0] + " Profile";
    	}
		logger.info("***** "+ profileString);
    	return profileString;
    }
    
}