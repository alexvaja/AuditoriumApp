package smartCardUniversity.LOGIN.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import smartCardUniversity.LOGIN.exception.UserAlreadyExistException;
import smartCardUniversity.LOGIN.models.DTO.RegisterDTO;
import smartCardUniversity.LOGIN.service.UserService;
import smartCardUniversity.SHARED.model.entity.Register;

@Controller
public class RegisterController implements WebMvcConfigurer {

	private static String VIEW_PATH = "views/shared/RegisterView";
	
	@Autowired
	private UserService userService;

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
		
		Register registered = new Register();

		if (!result.hasErrors()) {
			registered = createUserAccount(registerDTO, result);			
		}

		if (registered == null) {
			result.rejectValue("email", "message.regError");
		}
		
		if (result.hasErrors()) {
			System.out.println("SUNT ERORI LA EMAIL");
			return modelAndView;
		} else {
			System.out.println("E OK S-A SALVAT");
			return modelAndView;
		}
	}
	
	private Register createUserAccount(RegisterDTO registerDTO, BindingResult result) {
		
		Register registered = null;
		
		try {
			registered = userService.registerNewUserAccount(registerDTO);
		} catch (UserAlreadyExistException e) {
			return null;
		}
		
		return registered;
	}
}




//System.out.println("-- Am intrat in if --");
//System.out.println("------------------------");
//List<ObjectError> e = result.getAllErrors();
//for (ObjectError ee : e) {
//	System.out.println(ee);
//}
//
//List<ObjectError> eee = errors.getAllErrors();
//for (ObjectError ee : eee) {
//	System.out.println(ee);
//}