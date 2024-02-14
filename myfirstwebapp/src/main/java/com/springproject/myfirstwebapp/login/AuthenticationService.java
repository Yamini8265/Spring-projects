package com.springproject.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username,String password) {
		boolean user = username.equalsIgnoreCase("YaminiNamburi");
		boolean passcode = password.equalsIgnoreCase("password");
		
		return user && passcode;
	}

}
