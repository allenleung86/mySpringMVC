package com.allenleung.controller;

import com.allenleung.service.TestService;
import com.allenleung.serviceImpl.TestServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;


@Controller
@RequestMapping("/allenCtrl")
public class AllenController {
	private static final Logger log = Logger.getLogger(AllenController.class);

	@Autowired
	TestService service;

	@RequestMapping(value="/sayHello", method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		log.info( "into sayHello" );
		model.addAttribute( "message", "Allen, sayHello!" );

		return "sayHello";
	}

	@RequestMapping(value="/printWelcome", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		String pstr = service.print(2);
		log.info( "print str: " + pstr );
		model.addAttribute("message", pstr);
		return "hello";
	}

	@RequestMapping(value="/insertTest", method = RequestMethod.GET)
	public String insertTest() {
		int id = 123;
		String msg = "allenabcb";

		service.newContent(id, msg);

		return "success";
	}
}