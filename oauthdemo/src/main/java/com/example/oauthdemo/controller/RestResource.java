/**
 * 
 */
package com.example.oauthdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.oauthdemo.model.User;
import com.example.oauthdemo.model.UserProfile;

/**
 * @author USER
 *
 */
@Controller
public class RestResource {

	@RequestMapping("/api/users/me")
	public ResponseEntity<UserProfile> profile() {
		// Build some dummy data to return for testing
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = user.getUserName() + "@howtodoinjava.com";

		UserProfile profile = new UserProfile();
		profile.setName(user.getUserName());
		profile.setEmail(email);

		return ResponseEntity.ok(profile);
	}

}
