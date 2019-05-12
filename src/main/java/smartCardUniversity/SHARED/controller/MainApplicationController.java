package smartCardUniversity.SHARED.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainApplicationController {

	private final static Logger LOGGER = LoggerFactory.getLogger(MainApplicationController.class.getClass());
	@GetMapping("/index")
	public String startApp() {
		LOGGER.info("M-am logat si am ajuns pe pagina principala capra cu 3 iezi");
		return "index";
	}
}
