package spring.project.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.project.test.service.DBServiece;

@Controller
public class HomeController {
	
	@Autowired
	DBServiece dbs;
	
	@RequestMapping("/")
	public ModelAndView home(HttpServletRequest req, ModelAndView mav) {
//		dbs.dbTest();
		System.out.println("home()");
		
		mav.setViewName("home");
		return mav;
	}
	
//	@RequestMapping("/ads")
//	public void ads() {
//		System.out.println("ads()");
//		dbs.ads();
//	}
	
	public void test() {
		dbs.test();
	}
}
