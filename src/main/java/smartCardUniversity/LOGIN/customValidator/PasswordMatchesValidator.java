package smartCardUniversity.LOGIN.customValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import smartCardUniversity.LOGIN.customValidator.annotation.PasswordMatches;
import smartCardUniversity.LOGIN.models.DTO.RegisterDTO;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object>{

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {       
    }
    
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		System.out.println("AM INTRAT IN VALIUDARE PAROLE");
		final RegisterDTO registerDTO = (RegisterDTO) value;
		System.out.println("VALIDARE PAROLE: " + (registerDTO.getPassword().equals(registerDTO.getMatchingPassword())));
		return registerDTO.getPassword().equals(registerDTO.getMatchingPassword());
	}

}
