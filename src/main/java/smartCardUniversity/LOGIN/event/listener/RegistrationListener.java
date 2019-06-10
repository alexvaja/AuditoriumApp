package smartCardUniversity.LOGIN.event.listener;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import smartCardUniversity.LOGIN.event.OnRegistrationCompleteEvent;
import smartCardUniversity.LOGIN.service.RegisterService;
import smartCardUniversity.SHARED.model.entity.AppUser;
import smartCardUniversity.SHARED.model.entity.VerificationToken;
import smartCardUniversity.SHARED.repositories.VerificationTokenRepository;

public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

	@Autowired
	private RegisterService service;
	
	@Autowired
	private VerificationTokenRepository tokenRepository;
	
	@Autowired
	private MessageSource messages;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Environment env;
	
	@Override
	public void onApplicationEvent(OnRegistrationCompleteEvent event) {
		System.out.println("Am intrat in constructorul de la LISTENER");
		this.confirmRegistration(event);
	}
	
	@Transactional
	private void confirmRegistration(OnRegistrationCompleteEvent event) {
		System.out.println("Am intrat in functia apelata de constrictor");
		AppUser user = event.getAppUser();
		System.out.println("USER: " + user);
		String token = UUID.randomUUID().toString();
		System.out.println("TOKEN: " + token);
		
		System.out.println("Salvare token");
		VerificationToken newToken = new VerificationToken(token, user);
		System.out.println("TOKENUL FORMAT: " + newToken);
		//tokenRepository.save(newToken);
		//service.createVerificationTokenForUser(user, token);
		System.out.println("TOKEN-UL a fost salvat");
		
		SimpleMailMessage email = constructEmailMessage(event, user, token);
		mailSender.send(email);
	}
	
    private final SimpleMailMessage constructEmailMessage(final OnRegistrationCompleteEvent event, final AppUser user, final String token) {
    	System.out.println("Am intrat in constructie mail;");
    	
    	final String recipientAddress = user.getEmail();
        System.out.println("1");
    	final String subject = "Registration Confirmation";
        System.out.println("2");
    	final String confirmationUrl = event.getAppUrl() + "/registrationConfirm.html?token=" + token;
        
    	final String message = "Ana are mere!  ";//messages.getMessage("message.regSucc", null, event.getLocale());
        
    	final SimpleMailMessage email = new SimpleMailMessage();
        
    	email.setTo(recipientAddress);
        
    	email.setSubject(subject);
        
    	email.setText(message + " \r\n" + confirmationUrl);
        
    	email.setFrom(env.getProperty("support.email"));
    	return email;
    }
}
