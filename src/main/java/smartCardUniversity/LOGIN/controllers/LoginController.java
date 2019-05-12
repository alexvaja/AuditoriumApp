package smartCardUniversity.LOGIN.controllers;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.SessionScope;

import smartCardUniversity.SHARED.exceptions.NewSessionException;

@Controller
public class LoginController 
{
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@SessionScope
	@GetMapping({"/", "/LoginView"})
	public String openLoginPage(Model model, HttpSession session) throws NewSessionException 
	{
		LOGGER.info("Am intrat pe pagina de login prin Getmapping");
		return "views/shared/LoginView";
	}

}
