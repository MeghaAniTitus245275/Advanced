package com.BootSecurity.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.BootSecurity.MyUserDetailsService;
import com.BootSecurity.model.AuthenticationRequest;
import com.BootSecurity.model.AuthenticationResponse;
import com.BootSecurity.util.JwtUtil;


@RestController
public class EmployeeResource {
@Autowired
private AuthenticationManager authenticationManager;

@Autowired
private MyUserDetailsService myUserDetailsService;

@Autowired
private JwtUtil jwtUtil;
	@GetMapping("/")
	public String greet() {
		return "working";
	}
//	@GetMapping("/admin")
//	public String greetAdmin() {
//		return "Admin@word";
//		
//	}
//	@GetMapping
//	@RequestMapping("/user")
//	public String greetUser() {
//		return "User@work";
//	}
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
               System.out.println(authenticationRequest.getUsername() + authenticationRequest.getPassword());	
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}catch(BadCredentialsException e) {
			
			throw new Exception("Incorrect username or password",e);
		}
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
}