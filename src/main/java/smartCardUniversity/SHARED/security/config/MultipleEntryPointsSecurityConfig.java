package smartCardUniversity.SHARED.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class MultipleEntryPointsSecurityConfig 
{
	 @Bean
	 public UserDetailsService userDetailsService() throws Exception 
	 {
	        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	        manager.createUser(User.withUsername("silviu").password(encoder().encode("pass")).roles("EMPLOYEE").build());
	        manager.createUser(User.withUsername("diana").password(encoder().encode("pass")).roles("ADMIN").build());
	        return manager;
	 }
	 
	 @Bean
	 public PasswordEncoder encoder() 
	 {
	      return new BCryptPasswordEncoder();
	 }
}
