package com.BootSecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.BootSecurity.model.MyUserDetails;
import com.BootSecurity.model.User;
import com.BootSecurity.repo.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	Optional<User> user= repo.findByUserName(username);
	user.orElseThrow(() -> ( new UsernameNotFoundException("Not Found: " + username ) ));
	
	return user.map(MyUserDetails::new).get();
	}

}
