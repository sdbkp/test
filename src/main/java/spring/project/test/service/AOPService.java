package spring.project.test.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class AOPService implements AOPServiceInterface {

	@Override
	public HashMap<String, Object> serviceTest(HttpServletRequest req) {
		System.out.println("serviceTest()");
		return new HashMap<String, Object>();
	}
	
}
