package smartCardUniversity.SHARED.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController 
{
	@GetMapping("/RegisterView")
	public String getMapping(Model model)
	{
		return "views/RegisterView";
	}
}
