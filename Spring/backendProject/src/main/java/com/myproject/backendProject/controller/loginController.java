package com.myproject.backendProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class loginController {
	@RequestMapping("/")
	public String main() {
		return "login";
	}

	@ResponseBody
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String loginCheck(@RequestBody User user) throws Exception {
		String res = "login fail";
		if (user.getId().equals("abcd") && user.getPassword().equals("1234")) {
			res = "login ok";
		}
		return res;
	}
}
