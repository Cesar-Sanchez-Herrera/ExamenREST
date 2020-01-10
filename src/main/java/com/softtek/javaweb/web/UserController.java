package com.softtek.javaweb.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.sofftek.javaweb.exceiption.UserAlreadyExistsException;
import com.softtek.javaweb.domain.dto.UserForm;
import com.softtek.javaweb.domain.mapper.EntityMapper;
import com.softtek.javaweb.domain.model.User;
import com.softtek.javaweb.service.UserRoleService;
import com.softtek.javaweb.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserRoleService userRoleService;
	
	@GetMapping (value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<User> getUserList(){
		return userService.getList();
	}
	
	@GetMapping (value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public User getUserList(@PathVariable("username") String username){
		return userService.getOne(username);
	}
	
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@RequestBody User requestBody) throws UserAlreadyExistsException {
		return userService.add(requestBody);
	}
	
	@PutMapping(value = "/{username}/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public User updateUser(@PathVariable("username") String username, @RequestBody User requestBody){
		return userService.update(requestBody);
	}
	
	@PatchMapping(value = "/{username}/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public User patchUser(@PathVariable("username") String username, @RequestBody User requestBody){
		return userService.patchUser(username, requestBody);
	}
	
	@DeleteMapping(value = "/{username}/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable("username") String username) {
		userService.delete(username);
	}
	
//	static final String HEADER = "headerTitle";
//	static final String SUBMIT_BTN = "frmLblSubmitBtn";
//
//	static final String EDIT_FORM = "user/edit";
//	static final String LIST_FORM = "user/list";
//
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public String userListController (Model model) {
//		model.addAttribute("users", userService.getList());	
//		return UserController.LIST_FORM;
//	}
//
//	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "home")
//	public String userHomeController () {
//		return "redirect:/";
//	}	
//
//	@RequestMapping(value = "/edit", method = RequestMethod.POST)
//	public String userDefaultEditController () {
//		return null;
//	}	
//
//	@RequestMapping(value = "/edit", method = RequestMethod.POST, params="advSearch")
//	public String userAdvancedSearch (Model model) {
//		model.addAttribute("userRoles", userRoleService.getList());	
//		return "user/advsrch";
//	}
//	
//	@RequestMapping(value = "/edit", method = RequestMethod.POST, params= {"search","userRoleId"})
//	public String userAdvancedSearchResult (@RequestParam("userRoleId")String id, Model model) {
//		model.addAttribute("users", userService.getUserByRoleId(id));
//		
//		return "user/list";
//	}
//	
//	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "cancel")
//	public String userCancelController (Model model) {
//		model.addAttribute("users", userService.getList());	
//		return UserController.LIST_FORM;
//	}	
//
//	@RequestMapping(value = "/edit", method = RequestMethod.GET, params = {"showDetail","id"})
//	public String userEditController (@RequestParam("id") String id, Model model) {
//		model.addAllAttributes(this.initializeEditForm("Edit User", "Update", EntityMapper.makeFormFromUser(userService.getOne(id)), null));
//		return UserController.EDIT_FORM;				
//	}	
//
//	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "Update")
//	public String userUpdateController (@ModelAttribute UserForm userForm, BindingResult results, Model model) {
//		ResponseStatus responseStatus = userService.update(userForm);
//		results.getAllErrors().forEach(err -> System.out.println("## Binding Errors: " + err));
//		if (responseStatus.isValid()) {
//			model.addAttribute("users", userService.getList());	
//			return UserController.LIST_FORM;				
//	   	} else {
//	   		model.addAllAttributes(this.initializeEditForm("Edit User", "Update", userForm, responseStatus));
//			return UserController.EDIT_FORM;				
//	   	}
//	}
//	
//	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "addNew")
//	public String userNewController (Model model) {
//   		model.addAllAttributes(this.initializeEditForm("Add New User", "Save", null, null));
//		return UserController.EDIT_FORM;				
//	}
//	
//	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "Save")
//	public String userSaveController (@ModelAttribute UserForm userForm, BindingResult results, Model model) {
//		ResponseStatus responseStatus = userService.add(userForm);
//		
//		if (responseStatus.isValid()) {
//			model.addAttribute("users", userService.getList());	
//			return UserController.LIST_FORM;				
//	   	} else {
//	   		model.addAllAttributes(this.initializeEditForm("Add New User", "Save", userForm, responseStatus));
//			return UserController.EDIT_FORM;				
//	   	}
//	}
//
//	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
//	public String userDeleteController (@ModelAttribute UserForm userForm, BindingResult results, Model model) {
//		ResponseStatus responseStatus = userService.delete(userForm.getUsername());
//		
//		if (responseStatus.isValid()) {
//			model.addAttribute("users", userService.getList());	
//			return UserController.LIST_FORM;				
//	   	} else {
//	   		model.addAllAttributes(this.initializeEditForm("Edit User", "Update", userForm, responseStatus));
//			return UserController.EDIT_FORM;				
//	   	}
//	}
//
//	private Map<String,Object> initializeEditForm (final String header, final String submitAction, UserForm userForm, ResponseStatus responseStatus) {
//		Map<String,Object> map = new HashMap<>();
//		
//		map.put(UserController.HEADER, header);
//		map.put(UserController.SUBMIT_BTN, submitAction);
//		if (userForm != null ) {
//			map.put("user", EntityMapper.makeUserFromForm(userForm));
//			map.put("passwordConfirm", userForm.getPasswordConfirm());
//		}		
//		map.put("userRoles", userRoleService.getList());
//		if (responseStatus != null) {
//			map.put("frmValMsgs", responseStatus.getServiceMsg());
//		}
//
//		return map;
//	}

}
