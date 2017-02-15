package com.lanyus.springmvcmybatis.controller;

import com.lanyus.springmvcmybatis.service.TestService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;


@Controller
@RequestMapping("/helloControl")
public class HelloController {
	private static final Logger log = Logger.getLogger(HelloController.class);

	@Resource
	TestService service;
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		String pstr = service.print(1);
		log.info( "print str: " + pstr );
		model.addAttribute("message", pstr);
		return "hello";
	}
}