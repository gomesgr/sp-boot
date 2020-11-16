package com.example.demoproject.aprendendo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AprendendoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AprendendoApplication.class, args);
	}

}

@RestController
class Hello {
	@GetMapping("/")
	String hello() {
		return "Hello";
	}
}