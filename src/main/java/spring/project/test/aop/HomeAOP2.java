package spring.project.test.aop;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class HomeAOP2 {
	
	@Pointcut("within(spring.project.test.controller.AOPController)")
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
		
		if (retVal == null) {
			Object[] obj = jp.getArgs();
			for (Object object : obj) {
				if (object instanceof HttpServletResponse) {
					HttpServletResponse res = (HttpServletResponse) object;
					res.reset();
					res.setCharacterEncoding("UTF-8");
					res.setContentType("text/html); charset=UTF-8");
					res.getWriter().print("ㅠㅠ");
				}
			}
		}
		
	}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("AOP :D");
		return jp.proceed();
	}
	
}
