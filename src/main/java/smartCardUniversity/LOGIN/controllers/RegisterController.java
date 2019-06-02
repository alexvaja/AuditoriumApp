package smartCardUniversity.LOGIN.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import smartCardUniversity.LOGIN.models.DTO.RegisterDTO;

@Controller
public class RegisterController implements WebMvcConfigurer {
	
	private static String VIEW_PATH = "views/shared/RegisterView";
	
	@GetMapping("/RegisterView")
	public ModelAndView getMapping(Model model) {
	
		ModelAndView modelView = new ModelAndView(VIEW_PATH);
		modelView.addObject("newUser", new RegisterDTO());

		return modelView;
	}

	@PostMapping("/RegisterView")
	private ModelAndView postMethod(Model model, @Valid @ModelAttribute("newUser") RegisterDTO registerDTO, BindingResult result) {

		ModelAndView modelAndView = new ModelAndView(VIEW_PATH);
 
	    if (result.hasErrors()) {
	    	System.out.println("-- Am intrat in if --");
	        return modelAndView;
	    }

		System.out.println("MODEL: " + registerDTO);

		return modelAndView;
	}
}