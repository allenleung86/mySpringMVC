package com.allenleung.web;

import com.allenleung.service.TestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/allenCtrl")
@Transactional(propagation = Propagation.REQUIRED) //事务控制
public class AllenController {
	private static final Logger log = Logger.getLogger(AllenController.class);

	@Autowired
	TestService testServiceImpl2;

	@RequestMapping(value="/returnDirect", method = RequestMethod.GET)
	public String returnDirect(ModelMap model) {
		log.info( "into returnDirect" );
		model.addAttribute( "message", "麟, sayHe你llo!" );

		return "result/returnDirect";
	}

	@RequestMapping(value="/queryTest", method = RequestMethod.GET)
	public String queryTest(ModelMap model) {
		String pstr = testServiceImpl2.print(2);
		log.info( "print str: " + pstr );
		model.addAttribute("message", pstr);
		return "result/queryTest";
	}

	/**
	 * @Author: 890170
	 * @Date: 2017-03-07 16:00
	 * @Description: 插入test表(带事务控制)
	 */
	@RequestMapping(value="/insertTest", method = RequestMethod.GET)
	@Transactional(propagation = Propagation.REQUIRED) //事务控制
	public String insertTest() {
		testServiceImpl2.newContent(0, "");
		testServiceImpl2.newContent2(0, "");

		return "result/insertTest";
	}

	/**
	 * @Author: 890170
	 * @Date: 2017-03-07 16:01
	 * @Description: 插入test表(不带事务控制)
	 */
	@RequestMapping(value="/insertTest2", method = RequestMethod.GET)
	public String insertTest2() {
		testServiceImpl2.newContent(0, "");
		testServiceImpl2.newContent2(0, "");

		return "result/insertTest";
	}
}