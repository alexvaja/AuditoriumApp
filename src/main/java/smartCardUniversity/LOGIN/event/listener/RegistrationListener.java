package smartCardUniversity.LOGIN.event.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import smartCardUniversity.LOGIN.event.OnRegistrationCompleteEvent;
import smartCardUniversity.LOGIN.service.IRegisterService;
import smartCardUniversity.SHARED.model.entity.AppUser;

public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

	@Autowired
	private IRegisterService service;
	
	@Autowired
	private MessageSource messages;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Environment env;
	
	@Override
	public void onApplicationEvent(OnRegistrationCompleteEvent event) {
		this.confirmRegistration(event);
	}
	
	private void confirmRegistration(OnRegistrationCompleteEvent event) {
		
		AppUser user = event.getAppUser();
		String token = UUID.randomUUID().toString();
		service.createVerificationTokenForUser(user, token);
		
		SimpleMailMessage email = constructEmailMessage(event, user, token);
		mailSender.send(email);
	}
	
    private final SimpleMailMessage constructEmailMessage(final OnRegistrationCompleteEvent event, final AppUser user, final String token) {
        final String recipientAddress = user.getEmail();
        final String subject = "Registration Confirmation";
        final String confirmationUrl = event.getAppUrl() + "/registrationConfirm.html?token=" + token;
        final String message = messages.getMessage("message.regSucc", null, event.getLocale());
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " \r\n" + confirmationUrl);
        email.setFrom(env.getProperty("support.email"));
        return email;
    }
}
