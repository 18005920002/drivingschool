package com.labs.framework.ac.service.impl;

import org.springframework.stereotype.Service;

import com.labs.framework.ac.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService{

	@Override
	public boolean login(String principal, String credential) {
		return credential.length()%2==0;
	}

}
