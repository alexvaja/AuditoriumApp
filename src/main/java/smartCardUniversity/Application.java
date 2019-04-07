package smartCardUniversity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
public class Application {

	private final static Logger LOGGER = LoggerFactory.getLogger(Application.class.getClass());

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
		LOGGER.info("--- START SMART CARD UNIVERSITY APP ---");
	}
}
