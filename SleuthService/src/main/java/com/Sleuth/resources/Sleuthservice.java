package com.Sleuth.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class Sleuthservice {
	
	private static final Logger logger = LoggerFactory.getLogger(Sleuthservice.class);
	
	@GetMapping("/data")
	public String sendResponse() {
		logger.info("in service");
		return " from service";
	}

}
