package smartCardUniversity.SHARED.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@Order(1)
public class DinerAdminConfigurationAdapter extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.antMatcher("/indexAdminDiner/**")
			.authorizeRequests().anyRequest().hasRole("ADMIN")
			.and().httpBasic().authenticationEntryPoint(authenticationEntryPoint());
	}
	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint()
	{
        BasicAuthenticationEntryPoint dinerAdminEntryPoint = new BasicAuthenticationEntryPoint();
        dinerAdminEntryPoint.setRealmName("diner admin realm");
        return dinerAdminEntryPoint;
	}
}
