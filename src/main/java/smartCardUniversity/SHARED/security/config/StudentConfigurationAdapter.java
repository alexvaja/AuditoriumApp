package smartCardUniversity.SHARED.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(3)
public class StudentConfigurationAdapter extends WebSecurityConfigurerAdapter
{
	protected void configure(HttpSecurity http) throws Exception
	{
		
	}
}
