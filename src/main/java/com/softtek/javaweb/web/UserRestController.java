package com.softtek.javaweb.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.javaweb.domain.model.User;
import com.softtek.javaweb.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	
	  @GetMapping("/listUsers")
	  List<User> all() { 
	    return userService.getList();
	  }
	  
	  
	  @GetMapping("/listUsers/{username}")
	  private User getUser(@PathVariable String username) {
		  return userService.getOne(username);
	  }
	
}
