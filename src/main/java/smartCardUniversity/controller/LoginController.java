package smartCardUniversity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController 
{
	@GetMapping("/LoginView")
	public String startApp() 
	{
		System.out.println("Am intrat in login!");
		return "views/LoginView";
	}

}
