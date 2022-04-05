package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class MyBookingAppApplication {
	@GetMapping("")
	public String showHomePage() {
		return "index";

	}
	public static void main(String[] args) {
		SpringApplication.run(MyBookingAppApplication.class, args);
	}

}
