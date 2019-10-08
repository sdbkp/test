package spring.project.test.aop;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

@Aspect
public class HomeAOP {
	
	@Autowired
	AopUtil au;
	
	@Pointcut("within(spring.project.test.controller.HomeController)")
	public void pointcut() {}
	
	long start, end;
	
	@Before("pointcut()")
	public void before(JoinPoint jp) {
		start = System.currentTimeMillis();
		System.out.println(jp.getSignature().toShortString() + ": Start :D");
	}
	
	@After("pointcut()")
	public void after(JoinPoint jp) {
		end = System.currentTimeMillis();
//		System.out.println(jp.getSignature().toShortString() + ": " + ( (float) ((end-start) / 1000)));
		System.out.println(jp.getSignature().toShortString() + ": End :D");
	}
	
	@Around("pointcut()")
	public ModelAndView around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("AOP :D");
		return au.checkParams(jp);
	}
	
	
}
