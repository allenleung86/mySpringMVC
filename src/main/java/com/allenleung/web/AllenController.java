package com.allenleung.web;

import com.allenleung.service.TestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/allenCtrl")
public class AllenController {
	private static final Logger log = Logger.getLogger(AllenController.class);

	@Autowired
	TestService service;

	@RequestMapping(value="/returnDirect", method = RequestMethod.GET)
	public String returnDirect(ModelMap model) {
		log.info( "into returnDirect" );
		model.addAttribute( "message", "麟, sayHe你llo!" );

		return "returnDirect";
	}

	@RequestMapping(value="/queryTest", method = RequestMethod.GET)
	public String queryTest(ModelMap model) {
		String pstr = service.print(2);
		log.info( "print str: " + pstr );
		model.addAttribute("message", pstr);
		return "queryTest";
	}

	@RequestMapping(value="/insertTest", method = RequestMethod.GET)
	public String insertTest() {
		//int id = 123;
		String msg = "allenabcb";

		service.newContent(0, msg);

		return "insertTest";
	}
}