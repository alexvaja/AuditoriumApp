package smartCardUniversity.LOGIN.customValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import smartCardUniversity.LOGIN.customValidator.annotation.ValidRegisterVM;
import smartCardUniversity.LOGIN.models.RegisterViewModel;
import smartCardUniversity.LOGIN.models.DTO.RegisterDTO;

public class RegisterVMValidator implements ConstraintValidator<ValidRegisterVM, Object> {

    @Override
    public void initialize(final ValidRegisterVM registerObject) {
    }
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		RegisterViewModel registerViewModel = (RegisterViewModel) value;
		
		@Valid RegisterDTO r = registerViewModel.getRegisterDTO();
		
		BindingResult result = null;
		Errors errors = null;
		
		return valid(r, result, errors);
	}
	
	public boolean valid(@Valid RegisterDTO r, BindingResult result, Errors errors) {
		System.out.println("AM INTRAT IN VALID");
		if (result.hasErrors()) {
			return true;
		}
		return false;
	}

}
