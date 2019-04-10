package smartCardUniversity.LOGIN.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import smartCardUniversity.LOGIN.models.LoginViewModel;
import smartCardUniversity.LOGIN.models.DTO.AppUserDTO;
import smartCardUniversity.SHARED.exceptions.NewSessionException;
import smartCardUniversity.SHARED.exceptions.WrongInputDataException;
import smartCardUniversity.SHARED.model.entity.AppUser;
import smartCardUniversity.SHARED.repositories.AppUserRepository;

@Controller
public class LoginController 
{
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AppUserRepository appUserRepo;
	
	@SessionScope
	@GetMapping("/LoginView")
	public String openLoginPage(Model model, HttpSession session) throws NewSessionException 
	{
		LOGGER.info("Am intrat pe pagina de login prin Getmapping");
//		if (session.isNew()) 
//		{
//			throw new NewSessionException();
//		}

		return "views/shared/LoginView";
	}

	@PostMapping("/LoginView")
	public String openLoginView(Model model, HttpSession session, @RequestParam("submit") String reqParam,
			@ModelAttribute LoginViewModel loginViewModel) throws WrongInputDataException 
	{
		Boolean viewLogInButton = false;
		model.addAttribute("viewLogInButton", viewLogInButton);
		// pe view model imi pun datele pe care le afisez pe pagina.

		model.addAttribute("newAppUserDTO", new AppUserDTO());

		switch (reqParam) 
		{
			case "Autentificare": 
			{
				AppUser appUser = new AppUser();
				viewLogInButton = true;
				model.addAttribute("viewLogInButton", viewLogInButton);
				
				if(loginViewModel.getUserDTO().getEmail().isEmpty()
					||loginViewModel.getUserDTO().getPassword().isEmpty())
						throw new WrongInputDataException();
				else
				{
					appUser.setEmail(loginViewModel.getUserDTO().getEmail()); 
					appUser.setPassword(loginViewModel.getUserDTO().getPassword());
					
					if(checkForUserInDataBase(appUser.getEmail(),appUser.getPassword())) 
					{
						
					}
				}
			}
		}
		return "views/shared/LoginView";
	}

	private List<AppUser> getListOfUsers() {
		final Iterable<AppUser> userList = appUserRepo.findAll();
		final List<AppUser> users = new ArrayList<>();
		for (final AppUser user : userList) {
			users.add(user);
		}
		return users;
	}

	private Boolean checkForUserInDataBase(String email, String password) {
		List<AppUser> users = getListOfUsers();
		for (AppUser user : users) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password))
				return true;
		}
		return true;
	}
}
