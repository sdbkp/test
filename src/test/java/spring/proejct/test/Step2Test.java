package spring.proejct.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.project.test.controller.HomeController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/test-context.xml"})
public class Step2Test {
	
	@Autowired
	HomeController hc;
	
	@Test
	public void test() {
//		String view = hc.home();
//		System.out.println(view);
//		assertEquals("home", view);
		
		hc.test();
	}

}
