package spring.project.test.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import spring.project.test.service.AOPServiceInterface;

@Controller
public class AOPController {
	
	@GetMapping("/aop1")
	public String aop1() {
		return "home";
	}
	
	@Autowired
	AOPServiceInterface aopsi;
	
	@GetMapping("/aop2")
	public void aop2(HttpServletRequest req, HttpServletResponse res) throws Throwable {
		System.out.println("aop2()");
		
		HashMap<String, Object> resultMap = aopsi.serviceTest(req);
		if (resultMap == null) {
			System.out.println("serviceTest: null");
		}
		
		System.out.println("dd");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html); charset=UTF-8");
		res.getWriter().print(":D");
	}
}
