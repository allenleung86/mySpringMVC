package com.allenleung.controller_bak;

import com.allenleung.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sadControl")
public class SadController {
	@Resource
	TestService service;
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", service.print(2));
		return "/WEB-INF/pages_bak/sad.jsp";
	}
}