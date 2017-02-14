package com.lanyus.springmvcmybatis.controller;

import com.lanyus.springmvcmybatis.service.TestService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping("*")
public class NotFoundController {
    private static final Logger log = Logger.getLogger(NotFoundController.class);

	@Resource
	TestService service;

	@RequestMapping("*")
	public String notFound() {
        log.info("notFound page!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return "error/404";
	}
}