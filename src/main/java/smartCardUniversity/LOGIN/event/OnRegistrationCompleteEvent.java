package smartCardUniversity.LOGIN.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import smartCardUniversity.SHARED.model.entity.AppUser;

@SuppressWarnings("serial")
public class OnRegistrationCompleteEvent extends ApplicationEvent {

	private String appUrl;
	private Locale locale;
	private AppUser appUser;
	
	public OnRegistrationCompleteEvent(String appUrl, Locale locale, AppUser appUser) {
		super(appUser);
		this.appUrl = appUrl;
		this.locale = locale;
		this.appUser = appUser;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public Locale getLocale() {
		return locale;
	}

	public AppUser getAppUser() {
		return appUser;
	}
}
