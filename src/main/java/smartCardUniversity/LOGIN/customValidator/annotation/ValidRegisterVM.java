package smartCardUniversity.LOGIN.customValidator.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import smartCardUniversity.LOGIN.customValidator.RegisterVMValidator;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Constraint(validatedBy = RegisterVMValidator.class)
public @interface ValidRegisterVM {

	String message() default "Invalid ceva";
	Class<?>[] groups() default {};
	Class<? extends Payload> [] payload() default {};
}
