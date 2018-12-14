package in.tcampus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.tcampus.model.WelcomeMessageBean;

@RestController
public class HelloWorldController {

	
	
	@GetMapping(path="/")
	public String welcome(){
		return new WelcomeMessageBean().getMessage();
	}
	
	@GetMapping(path="/welcome")
	public WelcomeMessageBean welcomeMessage(){
		return new WelcomeMessageBean();
	}
	
}
