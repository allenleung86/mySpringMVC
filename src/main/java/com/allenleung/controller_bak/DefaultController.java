package com.allenleung.controller_bak;

import com.allenleung.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class DefaultController {
	@Resource
	TestService service;
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", service.print(1));
		return "/WEB-INF/pages_bak/default.jsp";
	}
}