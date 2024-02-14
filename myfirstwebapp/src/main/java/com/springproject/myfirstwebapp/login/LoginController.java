package com.springproject.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	private AuthenticationService authencationService;

	
public LoginController(AuthenticationService authencationService) {
		super();
		this.authencationService = authencationService;
	}

//	@RequestMapping("/login")
//	public String loginPage(@RequestParam String name,ModelMap model) {
//		model.put("name", name);
//		return "loginPage";
//	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage() {
		
		return "loginPage";
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String WelcomePage(@RequestParam String name,@RequestParam String password, ModelMap model) {
		
		if(authencationService.authenticate(name, password)) {
		model.put("name", name);
		return "WelcomePage";
		
		}
		String error = "Incorrect Details";
		model.put("Error", error);
		return "loginPage";
	}
}
