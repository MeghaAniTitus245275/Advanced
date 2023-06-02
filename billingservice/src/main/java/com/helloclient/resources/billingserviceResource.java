package com.helloclient.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/billingservice")

public class billingserviceResource {
	
	@GetMapping()
	public String Welcome() {
		return "programming billing services";
	}
	
	@GetMapping("/statusbill")
	public String status() {
		return "Up and running billing services->>";
	}

}
