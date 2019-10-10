package spring.project.test.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public interface AOPServiceInterface {
	
	public HashMap<String, Object> serviceTest(HttpServletRequest req);
	
}
