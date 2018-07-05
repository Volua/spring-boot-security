package ua.springweb.security.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.springweb.security.domain.LoginRequest;
import ua.springweb.security.domain.RegisterRequest;
import ua.springweb.security.entity.UserEntity;
import ua.springweb.security.mapper.UserMapper;
import ua.springweb.security.service.UserService;

@Controller
public class BaseController {

	@Autowired UserService userService;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("userModel", new LoginRequest());
		return "login";
	}
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("registerModel", new RegisterRequest());
		return "register";
	}
	
	@PostMapping("/register")
	public String saveUser(@ModelAttribute("registerModel") RegisterRequest request) {
		userService.saveUser(UserMapper.registerToUser(request));
		
		return "redirect:/login";
	}
	
	@GetMapping("/profile")
	// @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public String showProfile(Principal principal, Model model) {
		UserEntity entity = 
				userService.findUserByEmail(principal.getName());
		
		model.addAttribute("user", entity);
		return "profile";
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showAdmin() {
		return "admin";
	}
	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String showUser() {
		return "user";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/dashboard")
	public String showDashboard() {
		return "dashboard";
	}
}
