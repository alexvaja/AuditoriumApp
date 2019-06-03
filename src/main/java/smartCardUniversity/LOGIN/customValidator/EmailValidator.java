package smartCardUniversity.LOGIN.customValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import smartCardUniversity.LOGIN.customValidator.annotation.ValidEmail;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {//TODO

	private Pattern pattern;
	
	private Matcher matcher;
	//TODO de refacut acesta
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@" + 
	"[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$"; 
	
	@Override
    public void initialize(ValidEmail constraintAnnotation) {       
    }
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println("AM INTRAT IN VALIUDARE EMAIL");
		return validateEmail(value);
	}
	
	private boolean validateEmail(String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
