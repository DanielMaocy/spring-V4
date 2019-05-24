package com.maocy.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.maocy.entity.User;

@Service
public class UserService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = new User();
		user.setUserName(username);
		if ("admin".equals(username)) {
			user.setPassword("123456");
		} else if ("user".equals(username)) {
			user.setPassword("456789");
		} else {
			return null;
		}
		return user;
	}

}
