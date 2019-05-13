package smartCardUniversity.LOGIN.controllers;
import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import smartCardUniversity.SHARED.exceptions.NewSessionException;
import smartCardUniversity.SHARED.utils.WebUtils;

@Controller
public class LoginController 
{
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {
		LOGGER.info("am intrat mai ceva ca Hitler in Polonia cu panzerul");
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);
		return "adminPage";
	}
	
	@SessionScope
	@GetMapping({"/", "/LoginView"})
	public String openLoginPage(Model model, HttpSession session) throws NewSessionException 
	{
		LOGGER.info("Am intrat pe pagina de login prin Getmapping");
		return "views/shared/LoginView";
	}
	
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		return "views/shared/loginView";
	}
	
}
