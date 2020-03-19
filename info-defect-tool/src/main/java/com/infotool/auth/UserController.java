package com.infotool.auth;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infotool.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 6000)
@RestController
public class UserController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody User login) throws ServletException {
		System.out.println("IN AUTH");
	    String jwtToken = "";

	    if (login.getUserName() == null || login.getPassword() == null) {
	        throw new ServletException("Please fill in username and password");
	    }

	    String email = login.getUserName();
	    String password = login.getPassword();
	    
	  //  User user = userService.findByEmail(email);
	    User user = new User();
	    user.setPassword("admin");
	    user.setUserName("admin");
	    
	    if (user == null) {
	        throw new ServletException("User email not found.");
	    }

	    String pwd = user.getPassword();

	    if (!password.equals(pwd)) {
	        throw new ServletException("Invalid login. Please check your name and password.");
	    }

	    jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
	            .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

	    return jwtToken;
	}
}
