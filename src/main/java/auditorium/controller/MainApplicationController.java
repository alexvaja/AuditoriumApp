package auditorium.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainApplicationController {

	@GetMapping("/")
	public String startApp() {
		System.out.println("Am intrat aici!");
		return "ceva";
	}
}
