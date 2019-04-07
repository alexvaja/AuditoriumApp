package smartCardUniversity.SHARED.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainApplicationController {

	private final static Logger LOGGER = LoggerFactory.getLogger(MainApplicationController.class.getClass());

	@GetMapping("/")
	public String startApp() {
		LOGGER.info("Am intrat aici");
		return "index";
	}

	@PostMapping("/")
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
		LOGGER.info("Am intrat aici prin index!");
		return "index";
	}
}
