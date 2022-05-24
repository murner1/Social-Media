package com.cooksys.SocialMedia.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.SocialMedia.Services.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {
	private UserService userService;
}
