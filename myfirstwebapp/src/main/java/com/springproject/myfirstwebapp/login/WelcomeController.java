package com.springproject.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

//	@RequestMapping("/login")
//	public String loginPage(@RequestParam String name,ModelMap model) {
//		model.put("name", name);
//		return "loginPage";
//	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage(ModelMap model) {
		model.put("name", getLoggedInUsername());
		return "WelcomePage";
	}

	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();	

	    return authentication.getName();
}
}
