package auditorium.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainApplicationController {

	@GetMapping("/")
	public String startApp() {
		System.out.println("Am intrat aici!");
		return "index";
	}
	
	@GetMapping("/index")
	public String startAppByIndex() {
		System.out.println("Am intrat aici prin index!");
		return "index";
	}
}
