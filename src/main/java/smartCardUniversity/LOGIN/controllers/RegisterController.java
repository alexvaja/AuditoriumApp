package smartCardUniversity.LOGIN.controllers;

import java.util.Calendar;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import smartCardUniversity.LOGIN.event.OnRegistrationCompleteEvent;
import smartCardUniversity.LOGIN.exception.UserAlreadyExistException;
import smartCardUniversity.LOGIN.models.DTO.RegisterDTO;
import smartCardUniversity.LOGIN.service.RegisterService;
import smartCardUniversity.SHARED.model.entity.AppUser;
import smartCardUniversity.SHARED.model.entity.VerificationToken;

@Controller
public class RegisterController implements WebMvcConfigurer {

	private static String VIEW_PATH = "views/shared/RegisterView";
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
    @Autowired
    private MessageSource messages;

	@GetMapping("/RegisterView")
	public ModelAndView getMapping(Model model) {

		ModelAndView modelView = new ModelAndView(VIEW_PATH);
		modelView.addObject("newUser", new RegisterDTO());

		return modelView;
	}

	@PostMapping("/RegisterView")
	private ModelAndView postMethod(Model model, @ModelAttribute("newUser") @Valid RegisterDTO registerDTO,
			BindingResult result, WebRequest request, Errors errors) {

		System.out.println("MODEL: " + registerDTO);
		ModelAndView modelAndView = new ModelAndView(VIEW_PATH);
		modelAndView.addObject("newUser", registerDTO);

		if (result.hasErrors()) {
			return modelAndView;
		}

		AppUser registered = createUserAccount(registerDTO, result);			

		if (registered == null) {
			result.rejectValue("email", "message.regError");
		}
		
		try {
			String appUrl = request.getContextPath();
			eventPublisher.publishEvent(new OnRegistrationCompleteEvent(appUrl, request.getLocale(), registered));
		} catch (Exception e) {
			System.out.println("AM PRINS CEVA EXCEPTIE");
			return modelAndView;
		}
		
		System.out.println("TOTUL A MERS BINE------->>");
		return modelAndView;
//		if (result.hasErrors()) {
//			System.out.println("SUNT ERORI LA EMAIL");
//			return modelAndView;
//		} else {
//			System.out.println("E OK S-A SALVAT");
//			return modelAndView;
//		}
	}
	
	@GetMapping("/registrationConfirm")
	public String confirmationRegistration(WebRequest request, Model model, @RequestParam("token") String token) {
		Locale locale = request.getLocale();
	     
	    VerificationToken verificationToken = registerService.getVerificationToken(token);
	    if (verificationToken == null) {
	        String message = messages.getMessage("auth.message.invalidToken", null, locale);
	        model.addAttribute("message", message);
	        return "redirect:/badUser.html?lang=" + locale.getLanguage();
	    }
	     
	    AppUser user = verificationToken.getAppUser();
	    Calendar cal = Calendar.getInstance();
	    if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
	        String messageValue = messages.getMessage("auth.message.expired", null, locale);
	        model.addAttribute("message", messageValue);
	        return "redirect:/badUser.html?lang=" + locale.getLanguage();
	    } 
	     
	    user.setEnabled(true); 
	    registerService.saveRegisteredUser(user); 
	    return "redirect:/views/LoginView.html?lang=" + request.getLocale().getLanguage();
		
	}
	
	private AppUser createUserAccount(RegisterDTO registerDTO, BindingResult result) {
		
		AppUser registered = null;
		
		try {
			registered = registerService.registerNewUserAccount(registerDTO);
		} catch (UserAlreadyExistException e) {
			return null;
		}
		
		return registered;
	}
}