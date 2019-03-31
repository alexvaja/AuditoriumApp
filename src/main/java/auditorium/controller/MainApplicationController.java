package auditorium.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainApplicationController {

	@GetMapping("/")
	public String startApp() {
		System.out.println("Am intrat aici!");
		return "index";
	}

	@PostMapping("/index")
	public String startAppByIndex(@RequestParam("submit") String reqParam) {
		switch (reqParam) 
		{
			case "Login": 
			{
				return "redirect:LoginView";
			}
			case "Register": 
			{
				return "redirect:RegisterView";
			}
		}
		System.out.println("Am intrat aici prin index!");
		return "index";
	}
}
