package spring.project.test.aop;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AOPUtil {
	
	public ModelAndView checkParams(ProceedingJoinPoint jp) throws Throwable {
		ModelAndView mav = new ModelAndView();
		Object[] obj = jp.getArgs();
		System.out.println("Arguments: " + obj.length);
		
		for (int i = 0; i < obj.length; i++) {
			Object object = obj[i];
			
			if (object instanceof HttpServletRequest) {
				if (!checkRequest(object)) {
					mav.setViewName("home2");
					return mav;
				}
			} else {
				System.out.println("ss");
			}
		}
		
		return (ModelAndView) jp.proceed();
	}
	
	public boolean checkRequest(Object obj) {
		System.out.println("dd");
		HttpServletRequest req = (HttpServletRequest) obj;
		Enumeration<?> enu = req.getParameterNames();
		boolean flag = true;
		
		while (enu.hasMoreElements()) {
			String name = enu.nextElement().toString();
			String value = req.getParameter(name);
			System.out.print(name + ": ");
			System.out.println(value);
			
			if ("".equals(value)) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
