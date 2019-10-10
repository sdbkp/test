package spring.project.test.aop;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class HomeAOP3 {
	
	@Pointcut("within(spring.project.test.service.AOPService)")
	public void pointcut() {}
	
	@Before("pointcut()")
	public void before(JoinPoint jp) {
		System.out.println(jp.getSignature().toShortString() + ": Start :D");
	}
	
	@After("pointcut()")
	public void after(JoinPoint jp) {
		System.out.println(jp.getSignature().toShortString() + ": End :D");
	}
	
	@AfterReturning(pointcut="pointcut()", returning="retVal")
	public void afterReturning(JoinPoint jp, Object retVal) throws Throwable {
		System.out.println(retVal);
		
	}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("AOP :D");
		
		Object[] obj = jp.getArgs();
		System.out.println("Param Size: " + obj.length);
		for (Object object : obj) {
			if (object instanceof HttpServletRequest) {
				HttpServletRequest req = (HttpServletRequest) object;
				Enumeration<?> enu = req.getParameterNames();
				
				List<String> paramNames = new ArrayList<String>();
				while (enu.hasMoreElements()) {
					String name = enu.nextElement().toString();
					String value = req.getParameter(name);
					System.out.print(name + ": ");
					System.out.println(value);
					paramNames.add(name);
				}
				
				boolean flag = false;
				for (String name : paramNames) {
					if ("name".equals(name)) {
						flag = true;
					}
				}
				System.out.println(flag);
				if (!flag) return null;
			}
		}
		
		return jp.proceed();
	}
	
}
